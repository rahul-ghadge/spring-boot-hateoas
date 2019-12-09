package com.arya.demo.exception;

import java.util.Date;


public class ErrorDetails {

	private Date timestamp;
	
	private int status;
	
	private String error;
	
	private String message;
	
	private String details;

	public ErrorDetails(Date timestamp, int status, String error, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public int getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}
