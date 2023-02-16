package com.stackroute.propertyownerservice.exception;

import java.time.LocalDateTime;

public class ErrorInformation {
	
	private String errorMessage;
	private String errorCode;
	private LocalDateTime time;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	public ErrorInformation() {
		super();
	}
	
	public ErrorInformation(String errorMessage, String errorCode, LocalDateTime time) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.time = time;
	}

}
