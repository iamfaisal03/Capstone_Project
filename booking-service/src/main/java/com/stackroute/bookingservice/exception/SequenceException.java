package com.stackroute.bookingservice.exception;

public class SequenceException extends Exception {
		
		private static final long serialVersionUID = 1L;
			
			private final String message;

			@Override
			public String getMessage() {
				return message;
			}

			public SequenceException(String message) {
				super();
				this.message = message;
			}
}
