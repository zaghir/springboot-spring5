package com.zaghir.project.todo.repository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zaghir.project.todo.domain.ToDo;

@Repository
public class ToDoRepository {

    private List<ToDo> toDos = new LinkedList<ToDo>(Arrays.asList(
            new ToDo("Read a Book"),
            new ToDo("Buy Milk"),
            new ToDo("Go to SpringOne Platform 2018", true)
    ));


    public Iterable<ToDo> findAll(){
        return this.toDos;
    }

    public ToDo findById(String id){
        return toDos.stream().filter( t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    public ToDo save(ToDo t){
        this.toDos.add(t);
        return t;
    }
}

