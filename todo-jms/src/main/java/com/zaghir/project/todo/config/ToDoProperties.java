package com.zaghir.project.todo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "todo.jms")
public class ToDoProperties {
	
	private String destination;
	
}
