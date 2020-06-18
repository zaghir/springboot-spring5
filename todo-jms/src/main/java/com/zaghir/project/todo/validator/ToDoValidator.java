package com.zaghir.project.todo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.zaghir.project.todo.domain.ToDo;

public class ToDoValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(ToDo.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ToDo toDo = (ToDo) target;
		if (toDo == null) {
			errors.reject(null, "ToDo cannot be null");
		} else {
			if (toDo.getDescription() == null || toDo.getDescription().isEmpty())
				errors.rejectValue("description", null, "description cannotbe null or empty");
		}
	}
}