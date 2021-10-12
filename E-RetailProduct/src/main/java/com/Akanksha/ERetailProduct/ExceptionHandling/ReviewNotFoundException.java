package com.Akanksha.ERetailProduct.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReviewNotFoundException extends RuntimeException {
	
	private String exception="Review Not Found..Please Enter valid input Value";
	
	public ReviewNotFoundException(String exception) {
		super(exception);
	}
	public String getException() {
		return exception;
	}

}
