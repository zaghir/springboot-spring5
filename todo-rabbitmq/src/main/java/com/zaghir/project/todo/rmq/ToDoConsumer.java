package com.zaghir.project.todo.rmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zaghir.project.todo.domain.ToDo;
import com.zaghir.project.todo.repository.ToDoRepository;

@Component
public class ToDoConsumer {
	private Logger log = LoggerFactory.getLogger(ToDoConsumer.class);
	
	@Autowired
	private ToDoRepository repository;

	
	@RabbitListener(queues = "${todo.amqp.queue}")
	public void processToDo(ToDo todo) {
		log.info("Consumer> " + todo);
		log.info("ToDo created> " + this.repository.save(todo));
	}
}
