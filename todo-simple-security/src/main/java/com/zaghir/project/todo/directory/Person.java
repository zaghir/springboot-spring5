package com.zaghir.project.todo.directory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
	private String email;
	private String password;
	private String role;
	private boolean enabled;
}