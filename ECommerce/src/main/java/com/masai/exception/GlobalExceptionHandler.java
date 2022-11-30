package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyErrorDetails> productException(ProductException pe,WebRequest er){
		
		MyErrorDetails med = new MyErrorDetails();
		med.setLocalDateTime(LocalDateTime.now());
		med.setMessage(pe.getMessage());
		med.setDetails(er.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(med,HttpStatus.BAD_REQUEST);
	}
	
	
}
