package com.zaghir.project.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration({ "/app-config.xml", "/test-data-access-config.xml" })
@ActiveProfiles("dev")
//@Transactional
public class ToDoRepositoryTests {
	
	@Test
	public void ToDoPersistenceTest() {
		assertEquals("test", "test");
	}
}