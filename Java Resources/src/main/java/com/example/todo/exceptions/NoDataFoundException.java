package com.example.todo.exceptions;

/**
 * @author Vaibhav Deshmukh
 * @version 0.0.1
 *
 */
public class NoDataFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private Object[] objectArray;

	public NoDataFoundException(String code, Object[] array) {
		this.errorCode = code;
		this.objectArray = array;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the objectArray
	 */
	public Object[] getObjectArray() {
		return objectArray;
	}

	/**
	 * @param objectArray
	 *            the objectArray to set
	 */
	public void setObjectArray(Object[] objectArray) {
		this.objectArray = objectArray;
	}

}
