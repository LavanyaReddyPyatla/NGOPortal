package com.capgemini.dto;

public class LoginSuccessMessage {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LoginSuccessMessage(String message) {
		super();
		this.message = message;
	}

}
