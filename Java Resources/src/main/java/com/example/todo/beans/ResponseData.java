package com.example.todo.beans;
/**
 * @author snehal
 * common response to return
 *
 */
public class ResponseData {
	private String response;
	private Object data;
	private String errorMessage;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ResponseData [response=" + response + ", data=" + data + ", errorMessage=" + errorMessage + "]";
	}

}
