package com.springbootunittesting.unittestspringbootmockingmockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.swing.text.AbstractDocument.Content;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
class HelloWolrdControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void helloWorld_basic() throws Exception {
		//call "/hello-world"
		// and verify that response contains "Hello World"
		
		// make a GET request
		// call GET "hello-world" application/json
		RequestBuilder request = MockMvcRequestBuilders
				.get("/hello-world")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World"))
				.andReturn();
		
		// verify "Hello World"
		// instead of assertEquals() we can use andExpect in perform method
		assertEquals("Hello World", result.getResponse().getContentAsString()); 
	}

}
