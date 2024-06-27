package com.example.demo.exception;

import lombok.Data;

@Data
public class RequestExceptionHandler extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;

	public RequestExceptionHandler(String code, String message) {
		super(message);
		this.code = code;
	}

}
