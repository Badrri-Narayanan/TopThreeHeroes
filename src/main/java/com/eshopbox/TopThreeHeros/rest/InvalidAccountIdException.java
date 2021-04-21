package com.eshopbox.TopThreeHeros.rest;

public class InvalidAccountIdException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidAccountIdException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidAccountIdException(String message) {
		super(message);
	}

	public InvalidAccountIdException(Throwable cause) {
		super(cause);
	}
	
}
