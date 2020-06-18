package com.zaghir.project.todo.controller;

import org.springframework.data.repository.CrudRepository;

import com.zaghir.project.todo.domain.ToDo;

public interface MyToDoController extends CrudRepository<ToDo, String> {

}
