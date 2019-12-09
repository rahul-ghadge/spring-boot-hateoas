package com.arya.demo.exception.handler;


public class SuperHeroNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SuperHeroNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
