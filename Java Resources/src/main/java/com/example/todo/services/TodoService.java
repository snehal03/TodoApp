package com.example.todo.services;

import java.util.List;

import com.example.todo.beans.TodoBean;
import com.example.todo.entities.TodoEntity;

public interface TodoService {

	List<TodoEntity> getAllTodoes(String filter);

	void createTodo(TodoBean todo);

	void updateTodo(TodoBean todo);

	void deleteTodo(int todoId);

	List<TodoEntity> searchTodoes(String type, String value);

	void changeTodoStatus(int id, String status);
}
