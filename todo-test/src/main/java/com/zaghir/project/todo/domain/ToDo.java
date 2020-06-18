package com.zaghir.project.todo.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class ToDo {


    private String id = "my-id";
    private String description;
    private boolean completed;
    private LocalDateTime created;
	private LocalDateTime modified;

    public ToDo(){
    	LocalDateTime date = LocalDateTime.now();
		this.id = UUID.randomUUID().toString();
		this.created = date;
		this.modified = date;
    }

    public ToDo(String description){
        this.description = description;
    }

    public ToDo(String description, boolean completed){
        this.description = description;
        this.completed = completed;
    }
}