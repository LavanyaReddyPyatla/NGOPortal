package com.capgemini.dto;

public class ErrorMessageDto {

	private String message;
	private String httpStatus;

	public ErrorMessageDto(String message, String httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public ErrorMessageDto() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

}
