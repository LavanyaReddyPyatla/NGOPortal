package com.capgemini.dto;

public class SuccessMessageDto {
	private String message;

	public SuccessMessageDto(String message) {
		this.message = message;
	}

	public SuccessMessageDto() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
