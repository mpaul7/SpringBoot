package com.springbootunittesting.unittestspringbootmockingmockito.spike;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {

	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	@Test
	public void jsonAssert_StrictTrue_ExactMAtchExceptForSpaces() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);	
	}

	@Test
	public void jsonAssert_StrictFalse() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);	
	}
	
	@Test
	public void jsonAssert_WithoutEscapeCharacter() throws JSONException {
		String expectedResponse = "{id:1, name:Ball, price:10, quantity:100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);	
	}

}
