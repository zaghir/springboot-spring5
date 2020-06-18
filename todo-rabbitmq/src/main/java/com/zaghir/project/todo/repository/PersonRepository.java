package com.zaghir.project.todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zaghir.project.todo.domain.Person;

public interface PersonRepository extends CrudRepository<Person, String> {
	public Person findByEmailIgnoreCase(@Param("email") String email);
}