package com.arya.demo.exception.handler;


public class AgeNotInRangeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AgeNotInRangeException(String errorMessage) {
        super(errorMessage);
    }

}
