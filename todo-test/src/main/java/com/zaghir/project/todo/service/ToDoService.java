package com.zaghir.project.todo.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zaghir.project.todo.domain.ToDo;
import com.zaghir.project.todo.repository.ToDoRepository;

@Service
public class ToDoService {

    private RestTemplate restTemplate;
    
    private ToDoRepository repository ; 
    public ToDoService(RestTemplateBuilder builder , ToDoRepository repository){
        this.restTemplate = builder.build();
        this.repository = repository ;
    }

    public ToDo findById(String id){
        return this.restTemplate.getForObject("/todo/{id}",ToDo.class,id);
    }
    
    public Iterable<ToDo> findAll(){
    	return this.repository.findAll();
    }
}

