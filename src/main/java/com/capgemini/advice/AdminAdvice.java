package com.capgemini.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.dto.ErrorMessageDto;
import com.capgemini.exception.DuplicateEmployeeException;
import com.capgemini.exception.NoSuchEmployeeException;

@RestControllerAdvice
public class AdminAdvice {

	@ExceptionHandler(NoSuchEmployeeException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleAddressException(NoSuchEmployeeException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.NOT_FOUND.toString());

	}

	@ExceptionHandler(DuplicateEmployeeException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleAddressException(DuplicateEmployeeException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.NOT_FOUND.toString());

	}

}