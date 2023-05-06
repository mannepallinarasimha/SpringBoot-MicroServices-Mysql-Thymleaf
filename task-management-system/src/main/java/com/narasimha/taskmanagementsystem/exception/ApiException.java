package com.narasimha.taskmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ApiException extends RuntimeException{
	private String message;

	public ApiException(String message) {
		super(message);
		this.message = message;
	}
	

}
