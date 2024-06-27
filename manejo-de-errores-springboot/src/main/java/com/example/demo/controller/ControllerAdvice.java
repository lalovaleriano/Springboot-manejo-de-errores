package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.ErrorDTO;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.RequestExceptionHandler;

@RestControllerAdvice
public class ControllerAdvice {

	/*
	 * Definimos que tipo de exceptions queremos controlar con anotacion
	 * 
	 * @exceptionHandler
	 */

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<ErrorDTO> runtimeExceptionHandler(RuntimeException e) {
		ErrorDTO err = ErrorDTO.builder().code("p-500").message(e.getMessage()).build();
		return new ResponseEntity<ErrorDTO>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = RequestExceptionHandler.class)
	public ResponseEntity<ErrorDTO> requestExceptionHandler(RequestExceptionHandler e) {
		ErrorDTO err = ErrorDTO.builder().code(e.getCode()).message(e.getMessage()).build();
		return new ResponseEntity<ErrorDTO>(err, HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<ErrorDTO> businessException(BusinessException e) {
		ErrorDTO err = ErrorDTO.builder().code(e.getCode()).message(e.getMessage()).build();
		return new ResponseEntity<ErrorDTO>(err, e.getStatus());
	}
}
