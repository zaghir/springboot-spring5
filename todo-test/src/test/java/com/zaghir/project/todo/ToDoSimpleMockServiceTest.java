package com.zaghir.project.todo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.zaghir.project.todo.domain.ToDo;
import com.zaghir.project.todo.repository.ToDoRepository;
import com.zaghir.project.todo.service.ToDoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToDoSimpleMockServiceTest {

	 @MockBean
    private ToDoRepository repository;
	
	@Autowired
	private ToDoService service ;
	
	@Test
    public void findAllTest() {
		LinkedList<ToDo> list = new LinkedList<ToDo>(Arrays.asList(
	            new ToDo("Search  a car "),
	            new ToDo("Buy a housse"),
	            new ToDo("Tack holiday", true)
	    ));
		
        given(this.repository.findAll()).willReturn(list);
		int counter = 0 ;
		for (ToDo toDo : service.findAll()) {
			System.out.println(toDo);
	        counter++;
	    }
		System.out.println();
        assertThat(counter).isEqualTo(3);
    }
	 
}
