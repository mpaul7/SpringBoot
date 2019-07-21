package com.springbootunittesting.unittestspringbootmockingmockito;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class ItemControllerIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	public void contextLoads() throws JSONException {
		String response = this.restTemplate.getForObject("/all-items-from-database", String.class);
		JSONAssert.assertEquals("[{id:1001}, {id:1002}, {id:1003}]", response, false);	
	}

}
