package com.zaghir.project.todo.rmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zaghir.project.todo.domain.ToDo;

@Component
public class ToDoProducer {
	private static final Logger log = LoggerFactory.getLogger(ToDoProducer.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

//	public ToDoProducer(RabbitTemplate template) {
//		this.rabbitTemplate = template;
//	}

	public void sendTo(String queue, ToDo toDo) {
		this.rabbitTemplate.convertAndSend(queue, toDo);
		log.info("Producer> Message Sent");
	}
}