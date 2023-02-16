package com.stackroute.bookingservice.exception;

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

	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<ErrorInformation> handleExceptionForBookingNotFound(BookingNotFoundException exception) {
		ErrorInformation errorInformation = new ErrorInformation();
		errorInformation.setErrorMessage(exception.getMessage());
		errorInformation.setErrorCode("100");
		errorInformation.setTime(LocalDateTime.now());
		return new ResponseEntity<>(errorInformation,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(RoomsNotAvailableException.class)
	public ResponseEntity<ErrorInformation> handleRoomsNotAvailable(RoomsNotAvailableException exception) {
		ErrorInformation errorInformation = new ErrorInformation();
		errorInformation.setErrorMessage(exception.getMessage());
		errorInformation.setErrorCode("101");
		errorInformation.setTime(LocalDateTime.now());
		return new ResponseEntity<>(errorInformation,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
