package com.capgemini.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.dto.ErrorMessageDto;
import com.capgemini.exception.NoSuchNeedyPeopleException;
import com.capgemini.exception.NoSuchRequestException;

@RestControllerAdvice
public class EmployeeAdvice {

	@ExceptionHandler(NoSuchNeedyPeopleException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleAddressException(NoSuchNeedyPeopleException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.NOT_FOUND.toString());

	}
	@ExceptionHandler(NoSuchRequestException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleAddressException(NoSuchRequestException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.NOT_FOUND.toString());

	}

}
