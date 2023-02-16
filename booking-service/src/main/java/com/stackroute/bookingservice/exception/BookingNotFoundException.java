package com.stackroute.bookingservice.exception;

public class BookingNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public BookingNotFoundException(String message) {
		super();
		this.message = message;
	}
}
