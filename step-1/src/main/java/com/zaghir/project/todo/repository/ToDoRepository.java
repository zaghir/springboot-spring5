package com.zaghir.project.todo.repository;

import org.springframework.data.repository.CrudRepository;

import com.zaghir.project.todo.domain.ToDo;

public interface ToDoRepository extends CrudRepository<ToDo,String> {

}
