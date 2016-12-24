package com.example.todo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.beans.TodoBean;
import com.example.todo.dao.TodoDao;
import com.example.todo.entities.TodoEntity;
import com.example.todo.services.TodoService;
import com.example.todo.utils.TodoUtil;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoDao todoDao;

	@Override
	public List<TodoEntity> getAllTodoes(String filter) {
		List<TodoEntity> todoList = new ArrayList<TodoEntity>();
		todoList = todoDao.getAllTodoes(filter);

		return todoList;
	}

	@Override
	public void createTodo(TodoBean todo) {
		TodoEntity todoEntity = TodoUtil.getTodoEntity(todo);
		todoDao.insert(todoEntity);
	}

	public void updateTodo(TodoBean todo) {
		// todoDao.updateTodoEntity(todo.getTodoId(), todo);
		TodoEntity entity = this.todoDao.getObjectById(todo.getTodoId());
		entity.setTodoName(todo.getTodoName());
		entity.setTodoText(todo.getTodoText());
		entity.setDueDate(todo.getDueDate());
		this.todoDao.update(entity);
	}

	@Override
	public void deleteTodo(int todoId) {
		this.todoDao.delete(todoId);
		// todoDao.deleteTodoEntity(todoId);
	}

	@Override
	public List<TodoEntity> searchTodoes(String type, String value) {
		List<TodoEntity> todoList = new ArrayList<TodoEntity>();
		todoList = todoDao.searchTodoes(type, value);
		return todoList;
	}

	@Override
	public void changeTodoStatus(int id, String status) {
		// todoDao.changeTodoStatus(id, status);
		TodoEntity todoEntity = this.todoDao.getObjectById(id);
		todoEntity.setTodoStatus(status);
		this.todoDao.update(todoEntity);
	}

}
