package com.example.todo.exceptions;

import org.apache.log4j.Logger;

/**
 * @author Vaibhav Deshmukh
 * @version 0.0.1
 */
public class DBException extends RuntimeException {

	private String message;

	private static final long serialVersionUID = 9L;

	private static final Logger LOGGER = Logger.getLogger(DBException.class);

	public DBException(String message) {
		super(message);
		this.message = message;
		LOGGER.error(message);
	}

	public DBException(String message, Throwable throwable) {
		super(message, throwable);
		this.message = message;
		LOGGER.error(message, throwable);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VerticalDBException [message=" + message + "]";
	}

}
