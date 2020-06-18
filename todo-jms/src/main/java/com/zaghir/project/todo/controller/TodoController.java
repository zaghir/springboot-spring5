package com.zaghir.project.todo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaghir.project.todo.domain.ToDo;
import com.zaghir.project.todo.jms.ToDoProducer;
import com.zaghir.project.todo.repository.ToDoRepository;

@RestController
@RequestMapping("/api")
public class TodoController {
	
	
	@Value("${todo.jms.destination}") 
	private String destination;
	
	@Autowired
	ToDoProducer producer;
	
	@Autowired
	ToDoRepository toDoRepository;
	
	@GetMapping("/toDos")
	public ResponseEntity<Iterable<ToDo>> getToDos() {
		producer.sendTo(destination, new ToDo("get All todos Request from Api"));
		return ResponseEntity.ok(toDoRepository.findAll());
	}
	
	@GetMapping("/todo/{id}")
	public ResponseEntity<ToDo> getToDoById(@PathVariable String id) {
		Optional<ToDo> toDo = toDoRepository.findById(id);
		producer.sendTo(destination, new ToDo("get todo with "+id+" Request from Api"));
		if(toDo.isPresent())
			return ResponseEntity.ok(toDo.get());
		
		return ResponseEntity.notFound().build();
	}
	

}
