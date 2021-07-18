package com.capgemini.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.dto.ErrorMessageDto;
import com.capgemini.exception.LoginException;
import com.capgemini.util.LoginConstants;

@RestControllerAdvice
public class UserAdvice {

	@ExceptionHandler(LoginException.class)
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	public ErrorMessageDto handleLoginException(LoginException ex) {
		return new ErrorMessageDto(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
	}

	@ExceptionHandler(MissingRequestHeaderException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleHeaderException(MissingRequestHeaderException ex) {
		return new ErrorMessageDto(HttpStatus.BAD_REQUEST.toString(), LoginConstants.MISSING_REQUEST_HEADER);
	}
}
