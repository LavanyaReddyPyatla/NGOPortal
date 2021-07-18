package com.capgemini.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.dto.ErrorMessageDto;
import com.capgemini.exception.DuplicateNeedyPersonException;
import com.capgemini.exception.InValidDetailsException;

@RestControllerAdvice
public class NeedyPeopleAdvice {

	@ExceptionHandler(DuplicateNeedyPersonException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleAddressException(DuplicateNeedyPersonException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.NOT_FOUND.toString());

	}

	@ExceptionHandler(InValidDetailsException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleAddressException(InValidDetailsException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.NOT_FOUND.toString());

	}

}
