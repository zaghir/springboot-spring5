package com.zaghir.project.todo;

import static org.assertj.core.api.Assertions.assertThat;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zaghir.project.todo.domain.ToDo;
import com.zaghir.project.todo.repository.CommonRepository;
import com.zaghir.project.todo.repository.ToDoRepositoryJdbc;

@RunWith(SpringRunner.class)
@JdbcTest
//utiliser cette configue pour utiliser la base de donnée habituelle si non spring utilise une H2 memory 
//@AutoConfigureTestDatabase(replace=Replace.NONE)
@Transactional
public class TodoJdbcTests {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private CommonRepository<ToDo> repository;

	@Test
	public void toDoJdbcTest() {
		ToDo toDo = new ToDo();
		toDo.setDescription("Read a Book");
		this.repository = new ToDoRepositoryJdbc(jdbcTemplate);
		this.repository.save(toDo);
		ToDo result = this.repository.findById(toDo.getId());
		assertThat(result.getId()).isEqualTo(toDo.getId());
	}
}