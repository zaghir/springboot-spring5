package com.zaghir.project.todo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zaghir.project.todo.domain.ToDo;
import com.zaghir.project.todo.rmq.ToDoProducer;

@EnableScheduling
@Configuration
public class ToDoSender {
	
//	@Bean
//	public CommandLineRunner sendToDos(@Value("${todo.amqp.queue}") String destination, ToDoProducer producer) {
//		return args -> {
//			producer.sendTo(destination, new ToDo("workout tomorrow morning!"));
//		};
//	}
		
	@Autowired
	private ToDoProducer producer;
	
	@Value("${todo.amqp.queue}")
	private String destination;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	// every	half second you send a message to the queue
	@Scheduled(fixedRate = 500L)
	private void sendToDos(){
		producer.sendTo(destination,new ToDo("Thinking on Spring Boot at "	+ dateFormat.format(new Date())));
	}
	
}