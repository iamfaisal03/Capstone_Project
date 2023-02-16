package com.stackroute.bookingservice.exception;

public class RoomsNotAvailableException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public RoomsNotAvailableException(String message) {
		super();
		this.message = message;
	}
}
