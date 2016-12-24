package com.example.todo.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author snehal todo entity
 *
 */
@Entity
@Table(name = "TODO")
public class TodoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "TODO_ID")
	private Integer todoId;

	@Column(name = "TODO_NAME", nullable = false)
	private String todoName;

	@Column(name = "TODO_TEXT")
	private String todoText;

	@Column(name = "TODO_STATUS", nullable = false)
	private String todoStatus;

	@Column(name = "CREATED_DATE", nullable = false)
	private Timestamp createdDate;

	@Column(name = "DUE_DATE", nullable = false)
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
		return "TodoEntity [todoId=" + todoId + ", todoName=" + todoName + ", todoText=" + todoText + ", todoStatus="
				+ todoStatus + ", createdDate=" + createdDate + ", dueDate=" + dueDate + "]";
	}

}
