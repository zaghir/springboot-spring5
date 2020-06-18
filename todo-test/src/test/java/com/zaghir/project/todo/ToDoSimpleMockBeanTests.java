package com.zaghir.project.todo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.zaghir.project.todo.domain.ToDo;
import com.zaghir.project.todo.repository.ToDoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToDoSimpleMockBeanTests {

    @MockBean
    private ToDoRepository repository;

    @Test
    public void toDoTest() {
        given(this.repository.findById("my-id")).willReturn(new ToDo("Read a Book"));
        assertThat(this.repository.findById("my-id").getDescription()).isEqualTo("Read a Book");
    }
}