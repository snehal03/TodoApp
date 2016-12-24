package com.example.todo.beans;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 *  @author snehal
 * todo bean 
 *
 */
@JsonIgnoreProperties(value = "true")
public class TodoBean {

	private Integer todoId;
	private String todoName;
	private String todoText;
	private String todoStatus;
	private Timestamp createdDate;
	private Timestamp dueDate;

	public Integer getTodoId() {
		return todoId;
	}

	public void setTodoId(Integer todoId) {
		this.todoId = todoId;
	}

	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

	public String getTodoText() {
		return todoText;
	}

	public void setTodoText(String todoText) {
		this.todoText = todoText;
	}

	public String getTodoStatus() {
		return todoStatus;
	}

	public void setTodoStatus(String todoStatus) {
		this.todoStatus = todoStatus;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getDueDate() {
		return dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "TodoBean [todoId=" + todoId + ", todoName=" + todoName + ", todoText=" + todoText + ", todoStatus="
				+ todoStatus + ", createdDate=" + createdDate + ", dueDate=" + dueDate + "]";
	}

}
