package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
	private String name;
	private String secondName;
	private String email;

}
