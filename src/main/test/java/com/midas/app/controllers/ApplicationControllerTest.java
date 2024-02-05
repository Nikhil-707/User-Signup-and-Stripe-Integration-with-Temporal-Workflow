package com.midas.app.controllers;

import com.midas.app.models.UserModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ApplicationControllerTest {

	private MockMvc mockMvc;

	@Mock
	private com.midas.app.utils.StripeIntegration stripeIntegration;

	@Test
	void signup() throws Exception {
		ApplicationController controller = new ApplicationController(stripeIntegration);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

		UserModel user = new UserModel();
		user.setEmail("test@example.com");

		when(stripeIntegration.createCustomer(anyString())).thenReturn("customer123");

		mockMvc.perform(MockMvcRequestBuilders.post("/signup")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"email\":\"test@example.com\"}"))
				.andExpect(status().isOk());

		verify(stripeIntegration, times(1)).createCustomer("test@example.com");
	}
}
