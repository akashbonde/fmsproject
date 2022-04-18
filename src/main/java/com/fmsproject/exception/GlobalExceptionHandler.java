package com.fmsproject.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NullValueFoundException.class)
	public ResponseEntity<Object> handleExceptions(NullValueFoundException nullValueFoundException, WebRequest webRequest){
		
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(nullValueFoundException.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
}
