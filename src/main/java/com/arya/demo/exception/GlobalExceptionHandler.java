package com.arya.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.arya.demo.exception.handler.AgeNotInRangeException;
import com.arya.demo.exception.handler.SuperHeroNotFoundException;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(SuperHeroNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleSuperHeroNotFoundException(SuperHeroNotFoundException ex, WebRequest request) {
		
		ErrorDetails errorDetails = new ErrorDetails(
				new Date(), 
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.name(),
				ex.getMessage(), 
				request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(AgeNotInRangeException.class)
	public final ResponseEntity<ErrorDetails> handleAgeNotInRangeException(AgeNotInRangeException ex, WebRequest request) {
		
		ErrorDetails errorDetails = new ErrorDetails(
				new Date(), 
				HttpStatus.NOT_ACCEPTABLE.value(),
				HttpStatus.NOT_ACCEPTABLE.name(),
				ex.getMessage(), 
				request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

}
