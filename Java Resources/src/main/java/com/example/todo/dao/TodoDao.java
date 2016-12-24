package com.example.todo.dao;

import java.util.List;

import com.example.todo.beans.TodoBean;
import com.example.todo.entities.TodoEntity;

public interface TodoDao extends AbstractDao<TodoEntity>{
	List<TodoEntity> getAllTodoes(String filter);
	void createEntity(TodoEntity todo);
	void updateTodoEntity(int todoId,TodoBean todo);
	void deleteTodoEntity(int todoId);
	List<TodoEntity> searchTodoes(String type, String value);
	void changeTodoStatus(int id, String status);
}
