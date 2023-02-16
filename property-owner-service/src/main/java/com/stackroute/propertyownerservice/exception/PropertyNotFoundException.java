package com.stackroute.propertyownerservice.exception;

public class PropertyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public PropertyNotFoundException(String message) {
		super();
		this.message = message;
	}
}
