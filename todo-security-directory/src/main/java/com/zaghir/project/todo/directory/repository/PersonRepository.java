package com.zaghir.project.todo.directory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zaghir.project.todo.directory.domain.Person;

public interface PersonRepository extends CrudRepository<Person, String> {
	public Person findByEmailIgnoreCase(@Param("email") String email);
}