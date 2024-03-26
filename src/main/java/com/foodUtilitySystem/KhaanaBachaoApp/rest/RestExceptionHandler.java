package com.foodUtilitySystem.KhaanaBachaoApp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler
	  public ResponseEntity<FoodExceptionHandler>handleException(FoodSaverNotFoundException e){
		FoodExceptionHandler seh = new FoodExceptionHandler();
		   seh.setStatuscode(HttpStatus.NOT_FOUND.value());
		   seh.setErrormessage(e.getMessage());
		   seh.setTimestamp(System.currentTimeMillis());
		   return new ResponseEntity<>(seh,HttpStatus.NOT_FOUND);
	  }
	  @ExceptionHandler
	  public ResponseEntity<FoodExceptionHandler>handleException(Exception e){
		  FoodExceptionHandler seh = new FoodExceptionHandler();
		   seh.setStatuscode(HttpStatus.BAD_REQUEST.value());
		   seh.setErrormessage(e.getMessage());
		   seh.setTimestamp(System.currentTimeMillis());
		   return new ResponseEntity<>(seh,HttpStatus.BAD_REQUEST);
	  }
}
