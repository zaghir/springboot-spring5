package com.zaghir.project.todo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaghir.project.todo.domain.ToDo;
import com.zaghir.project.todo.jms.ToDoProducer;

@Configuration
public class ToDoSender {
	
	
	@Bean
	public CommandLineRunner sendToDos(
			@Value("${todo.jms.destination}") String destination,
			ToDoProducer producer) {
		return args -> {
			producer.sendTo(destination, new ToDo("workout tomorrow morning!"));
		};
	}
}
