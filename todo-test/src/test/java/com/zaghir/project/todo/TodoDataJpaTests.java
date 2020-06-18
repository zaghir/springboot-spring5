package com.zaghir.project.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.zaghir.project.todo.domain.ToDo;
import com.zaghir.project.todo.repository.ToDoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
// utiliser cette configue pour utiliser la base de donnée habituelle si non spring utilise une H2 memory 
//@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TodoDataJpaTests {
	
	// 
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ToDoRepository repository;

	@Test
	public void toDoDataTest() throws Exception {
		this.entityManager.persist(new ToDo("Read a Book"));
//		Iterable<ToDo> toDos = this.repository.findByDescriptionContains("Read a Book");
//		assertThat(toDos.iterator().next()).toString().contains("Read a Book");
	}
}