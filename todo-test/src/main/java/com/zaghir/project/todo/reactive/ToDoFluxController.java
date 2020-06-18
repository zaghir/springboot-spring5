package com.zaghir.project.todo.reactive;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaghir.project.todo.domain.ToDo;
import com.zaghir.project.todo.repository.ToDoRepository;

import reactor.core.publisher.Flux;

@RestController
public class ToDoFluxController {

    private ToDoRepository repository;

    public ToDoFluxController(ToDoRepository repository){
        this.repository = repository;
    }

    @GetMapping("/todo-flux")
    public Flux<ToDo> getToDos() {
        return  Flux.fromIterable(this.repository.findAll());
    }
}
