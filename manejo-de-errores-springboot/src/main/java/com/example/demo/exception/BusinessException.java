package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
	/**
	* 
	*/
	private static final long serialVersionUID = 715721790050412286L;

	private String code;
	private HttpStatus status;

	public BusinessException(String message, String code, HttpStatus status) {
		super(message);
		this.code = code;
		this.status = status;
	}

}
