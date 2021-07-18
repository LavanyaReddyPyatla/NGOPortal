package com.capgemini.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.dto.ErrorMessageDto;
import com.capgemini.exception.DuplicateDonorException;
import com.capgemini.exception.InValidDetailsException;
import com.capgemini.exception.InvalidAmountException;
import com.capgemini.exception.NoSuchRequestException;

@RestControllerAdvice
public class DonorAdvice {

	@ExceptionHandler(DuplicateDonorException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleAddressException(DuplicateDonorException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.NOT_FOUND.toString());

	}

	@ExceptionHandler(InValidDetailsException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleAddressException(InValidDetailsException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.NOT_FOUND.toString());

	}

	@ExceptionHandler(NoSuchRequestException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleAddressException(NoSuchRequestException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.NOT_FOUND.toString());

	}

	@ExceptionHandler(InvalidAmountException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleAddressException(InvalidAmountException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.NOT_FOUND.toString());

	}
}
