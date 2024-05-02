package com.hivcaremanager.stockmanagement.exceptionhandler;  

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hivcaremanager.stockmanagement.dto.error.ApiError;
import com.hivcaremanager.stockmanagement.dto.error.ApiSubError;
import com.hivcaremanager.stockmanagement.dto.error.ApiValidationError;
import com.hivcaremanager.stockmanagement.exceptionhandler.exception.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

		final String message = "field validation error";	
	
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,message, ex);

		List<ApiSubError> apiSubErrors = new ArrayList<>();

		for (FieldError fieldError : ex.getFieldErrors()) {
			ApiSubError apiSubError = new ApiValidationError(fieldError.getObjectName(), fieldError.getField(),fieldError.getRejectedValue(),fieldError.getDefaultMessage());			
			apiSubErrors.add(apiSubError);
		}
	
		apiError.setSubErrors(apiSubErrors);
		return buildResponseEntity(apiError);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception) {

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, exception.getMessage(), exception);
		return buildResponseEntity(apiError);
	}
	@SuppressWarnings("null")
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}
