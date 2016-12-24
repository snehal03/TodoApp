package com.example.todo.utils;

import com.example.todo.beans.TodoBean;
import com.example.todo.entities.TodoEntity;

/**
 * @author snehal class for comon functions like return entity from bean
 */
public class TodoUtil {

	public static TodoEntity getTodoEntity(final TodoBean todo) {
		TodoEntity todoEntity = new TodoEntity();
		todoEntity.setTodoName(todo.getTodoName());
		todoEntity.setTodoStatus(todo.getTodoStatus());
		todoEntity.setTodoText(todo.getTodoText());
		todoEntity.setCreatedDate(todo.getCreatedDate());
		todoEntity.setDueDate(todo.getDueDate());
		return todoEntity;
	}
}
