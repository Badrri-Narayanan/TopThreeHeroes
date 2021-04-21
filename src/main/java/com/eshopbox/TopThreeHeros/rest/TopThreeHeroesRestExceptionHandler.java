package com.eshopbox.TopThreeHeros.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TopThreeHeroesRestExceptionHandler {

	//Global Exception Handling for the Top three heroes API is done here
	
	//handling the InvalidAccountIdException
	@ExceptionHandler
	public ResponseEntity<AccountIdErrorResponse> handleInvalidAccoundIdException (InvalidAccountIdException exc) {
		AccountIdErrorResponse error = new AccountIdErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	//Error response when the user has not played any games.
	@ExceptionHandler
	public ResponseEntity<NoGamesPlayedErrorResponse> handleNoGamesPlayedException(NoGamesPlayedException exc) {
		NoGamesPlayedErrorResponse error = new NoGamesPlayedErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	//Catch all exception handler
	@ExceptionHandler
	public ResponseEntity<AccountIdErrorResponse> handleException(Exception exc) {
		AccountIdErrorResponse error = new AccountIdErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage("Account ID must be numeric");
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
		
}
