package com.stackroute.propertyownerservice.exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	Environment environment;

	@ExceptionHandler(PropertyNotFoundException.class)
	public ResponseEntity<ErrorInformation> handleExceptionForPropertyNotFound(PropertyNotFoundException exception) {
		ErrorInformation errorInformation = new ErrorInformation();
		errorInformation.setErrorMessage(environment.getProperty(exception.getMessage()));
		errorInformation.setErrorCode("100");
		errorInformation.setTime(LocalDateTime.now());
		return new ResponseEntity<>(errorInformation,HttpStatus.INTERNAL_SERVER_ERROR);
	}
 	

}
