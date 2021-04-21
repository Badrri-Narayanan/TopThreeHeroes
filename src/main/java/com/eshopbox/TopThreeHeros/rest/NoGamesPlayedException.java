package com.eshopbox.TopThreeHeros.rest;

public class NoGamesPlayedException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoGamesPlayedException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoGamesPlayedException(String message) {
		super(message);
	}

	public NoGamesPlayedException(Throwable cause) {
		super(cause);
	}
	

}
