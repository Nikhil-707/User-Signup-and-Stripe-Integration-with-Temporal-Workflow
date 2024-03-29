package com.midas.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ApplicationTest {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		// Check if the Spring application context is not null
		assertNotNull(applicationContext);
	}
}
