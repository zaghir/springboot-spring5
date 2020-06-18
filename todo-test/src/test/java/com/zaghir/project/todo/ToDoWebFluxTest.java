package com.zaghir.project.todo;

import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.zaghir.project.todo.domain.ToDo;
import com.zaghir.project.todo.reactive.ToDoFluxController;
import com.zaghir.project.todo.repository.ToDoRepository;

@RunWith(SpringRunner.class)
@WebFluxTest(ToDoFluxController.class)
public class ToDoWebFluxTest {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private ToDoRepository toDoRepository;

    @Test
    public void testExample() throws Exception {
        given(this.toDoRepository.findAll())
                .willReturn(Arrays.asList(new ToDo("Read a Book"), new ToDo("Buy Milk")));
        this.webClient.get().uri("/todo-flux").accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class);
    }
}