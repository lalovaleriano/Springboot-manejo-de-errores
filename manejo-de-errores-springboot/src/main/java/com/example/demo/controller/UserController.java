package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.RequestExceptionHandler;

@RestController
@RequestMapping("/api")
public class UserController {

	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User usr) {
		if (usr.getEmail().equals("")) {
			throw new RequestExceptionHandler("p-500", "email requerido");
		}
		if(usr.getName().equals("")) {
			throw new BusinessException("name requerido","p-500",HttpStatus.CONFLICT);
			
		}
		return new ResponseEntity<>("obj usr", HttpStatus.CREATED);

	}

}
