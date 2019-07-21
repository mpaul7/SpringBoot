package com.springbootunittesting.unittestspringbootmockingmockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.springbootunittesting.unittestspringbootmockingmockito.business.ItemBusinessService;
import com.springbootunittesting.unittestspringbootmockingmockito.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
class ItemControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ItemBusinessService businessService;

	@Test
	public void dummyItem_basic() throws Exception {
		//call "/hello-world"
		// and verify that response contains "Hello World"
		
		// make a GET request
		// call GET "hello-world" application/json
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andReturn();
		
		// verify "Hello World"
		// instead of assertEquals() we can use andExpect in perform method
		//assertEquals("Hello World", result.getResponse().getContentAsString()); 
	}
	
	
	@Test
	public void ItemFromBusinessService_basic() throws Exception {
		when(businessService.retrieveHardcodedItem()).thenReturn(new Item(1, "Ball", 10, 100));
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:1, name:Ball, price:10, quantity:100}"))
				.andReturn();
		
		// verify "Hello World"
		// instead of assertEquals() we can use andExpect in perform method
		//assertEquals("Hello World", result.getResponse().getContentAsString()); 
	}
	
	@Test
	public void retrieveAllItems_basic() throws Exception {
		when(businessService.retrieveAllItems()).thenReturn(
				Arrays.asList(new Item(2, "Item2", 10, 10)));
		RequestBuilder request = MockMvcRequestBuilders
				.get("/all-items-from-database")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:2, name:Item2, price:10, quantity:10, value:0}]"))
				.andReturn();
		
		// verify "Hello World"
		// instead of assertEquals() we can use andExpect in perform method
		//assertEquals("Hello World", result.getResponse().getContentAsString()); 
	}
	

}
