package com.example.todo.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.beans.TodoBean;
import com.example.todo.dao.TodoDao;
import com.example.todo.entities.TodoEntity;
import com.example.todo.utils.CollectionUtils;

@Repository
@Transactional
public class TodoDaoImpl extends AbstractDaoImpl<TodoEntity> implements TodoDao {

	protected TodoDaoImpl() {
		super(TodoEntity.class);
	}

	/**
	 * Function for get all todoes list...Get filtered
	 * todoes(All,Completed,Pending)
	 */
	@Override
	public List<TodoEntity> getAllTodoes(String filter) {
		List<TodoEntity> todoes = new ArrayList<TodoEntity>();
		Session session = getSession();
		Criteria criteria = getCriteria(session);
		if (filter.equalsIgnoreCase("Completed"))
			criteria.add(Restrictions.eq("todoStatus", "Completed"));
		else if (filter.equalsIgnoreCase("Pending"))
			criteria.add(Restrictions.eq("todoStatus", "Pending"));
		todoes = CollectionUtils.castList(TodoEntity.class, criteria.list());
		return todoes;

	}

	/**
	 * Function for create todo
	 */
	@Override
	public void createEntity(TodoEntity todo) {
		Session session = getSession();
		session.save(todo);
		session.close();
	}

	/**
	 * Function to update todo
	 */
	@Override
	public void updateTodoEntity(int todoId, TodoBean todo) {
		TodoEntity todoEntity = new TodoEntity();
		Session session = getSession();
		todoEntity = (TodoEntity) session.load(TodoEntity.class, todoId);
		todoEntity.setTodoName(todo.getTodoName());
		todoEntity.setTodoText(todo.getTodoText());
		todoEntity.setDueDate(todo.getDueDate());
		session.update(todoEntity);

	}

	/**
	 * Function to delete todo
	 */
	@Override
	public void deleteTodoEntity(int todoId) {
		Session session = getSession();
		TodoEntity todoEntity = new TodoEntity();
		todoEntity = (TodoEntity) session.load(TodoEntity.class, todoId);
		session.delete(todoEntity);

	}

	/**
	 * Function to search todo by text and date
	 */
	@Override
	public List<TodoEntity> searchTodoes(String type, String value) {
		List<TodoEntity> todoes = new ArrayList<TodoEntity>();
		Session session = getSession();
		Criteria criteria = getCriteria(session);
		if (type.equalsIgnoreCase("text")) {
			System.out.println("session1==============="+session);
			Criterion todoText = Restrictions.ilike("todoText", "%" + value + "%");
			Criterion todoName = Restrictions.ilike("todoName", "%" + value + "%");
			LogicalExpression orExp = Restrictions.or(todoText, todoName);
			criteria.add(orExp);
		} else if (type.equalsIgnoreCase("date")) {

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			try {
				Date date = formatter.parse(value);
				criteria.add(Restrictions.lt("dueDate", date));
				criteria.add(Restrictions.gt("dueDate", new Date()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		todoes = CollectionUtils.castList(TodoEntity.class, criteria.list());
		return todoes;

	}

	@Override
	public void changeTodoStatus(int id, String status) {
		TodoEntity todoEntity = new TodoEntity();
		Session session = getSession();
		todoEntity = (TodoEntity) session.load(TodoEntity.class, id);
		todoEntity.setTodoStatus(status);
		session.update(todoEntity);

	}

}
