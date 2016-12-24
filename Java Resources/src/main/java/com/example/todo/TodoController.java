package com.example.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.todo.beans.ResponseData;
import com.example.todo.beans.TodoBean;
import com.example.todo.constants.Constants;
import com.example.todo.entities.TodoEntity;
import com.example.todo.services.TodoService;
/**
 * @author snehal
 * controller for todo function
 *
 */
@Controller
@RequestMapping(value = "/todo")
public class TodoController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private TodoService todoService;

	//function for get all todoes and filter todoes
	@ResponseBody
	@RequestMapping(value = "/getAllTodoes/{filter}", method = RequestMethod.GET)
	public ResponseData displayAllTodoes(@PathVariable("filter") String filter) {
		List<TodoEntity> todoList = new ArrayList<TodoEntity>();
		todoList = todoService.getAllTodoes(filter);

		ResponseData data = new ResponseData();
		data.setResponse(Constants.SUCCESS_RESPONSE);
		if (todoList.size() <= 0)
			data.setData(messageSource.getMessage("NoDataFound", new Object[] { null }, Locale.ENGLISH));
		else
			data.setData(todoList);
		return data;
	}

	//function for create todo
	@ResponseBody
	@RequestMapping(value = "/createTodo", method = RequestMethod.POST)
	public ResponseData createNewTodo(@RequestBody TodoBean todo) {
		todoService.createTodo(todo);

		ResponseData data = new ResponseData();
		data.setResponse(Constants.SUCCESS_RESPONSE);
		data.setData(messageSource.getMessage("todoCreated", new Object[] { todo.getTodoName() }, Locale.ENGLISH));

		return data;
	}
	//function for update todo
	@ResponseBody
	@RequestMapping(value = "/updateTodo", method = RequestMethod.POST)
	public ResponseData updateTodo(@RequestBody TodoBean todo) {
		todoService.updateTodo(todo);
		ResponseData data = new ResponseData();
		data.setResponse(Constants.SUCCESS_RESPONSE);
		data.setData(messageSource.getMessage("todoUpdated", new Object[] { null }, Locale.ENGLISH));

		return data;
	}
	//function for delete todo
	@ResponseBody
	@RequestMapping(value = "/deleteTodo", method = RequestMethod.DELETE)
	public ResponseData deleteTodo(@RequestParam(value="todoId") int todoId) {
		System.out.println("todoId========"+todoId);
		todoService.deleteTodo(todoId);

		ResponseData data = new ResponseData();
		data.setResponse(Constants.SUCCESS_RESPONSE);
		data.setData(messageSource.getMessage("todoDeleted", new Object[] { null }, Locale.ENGLISH));

		return data;
	}
	//function for search toddoes
	@ResponseBody
	@RequestMapping(value = "/searchTodoes/{type}/{value}", method = RequestMethod.GET)
	public ResponseData searchTodoes(@PathVariable("type") String type,@PathVariable("value") String value) {
		List<TodoEntity> todoList = new ArrayList<TodoEntity>();
		todoList = todoService.searchTodoes(type,value);

		ResponseData data = new ResponseData();
		data.setResponse(Constants.SUCCESS_RESPONSE);
		if (todoList.size() <= 0)
			data.setData(messageSource.getMessage("NoDataFound", new Object[] { null }, Locale.ENGLISH));
		else
			data.setData(todoList);
		return data;
	}
	// function to change todo status
	@ResponseBody
	@RequestMapping(value = "/changeTodoStatus/{id}/{status}", method = RequestMethod.POST)
	public ResponseData changeTodoStatus(@PathVariable("id") int id,@PathVariable("status") String status) {
		todoService.changeTodoStatus(id,status);

		ResponseData data = new ResponseData();
		data.setResponse(Constants.SUCCESS_RESPONSE);
		data.setData(messageSource.getMessage("statusChanged", new Object[] { null }, Locale.ENGLISH));
		return data;
	}
	
	
}
