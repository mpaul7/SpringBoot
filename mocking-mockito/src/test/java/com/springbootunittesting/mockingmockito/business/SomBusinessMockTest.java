package com.springbootunittesting.mockingmockito.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
//import org.mockito.Mockito.mock;
import com.springboot.unittesting.mockingmockito.business.SomeBusinessImpl;
import com.springboot.unittesting.mockingmockito.data.SomeDataService;


class SomBusinessMockTest {

	SomeBusinessImpl business = new SomeBusinessImpl();
	SomeDataService dataServiceMock = mock(SomeDataService.class);
	
	/*
	 * @Before public void before() { business.setSomeDataService(dataServiceMock);
	 * }
	 */
	 
	
	@Test
	void calculateSumUsingDataService_basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		business.setSomeDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void calculateSumUsingDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		business.setSomeDataService(dataServiceMock);
		assertEquals(0, business.calculateSumUsingDataService());
	}
	
	@Test
	void calculateSumUsingDataService_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1});
		business.setSomeDataService(dataServiceMock);
		assertEquals(1,  business.calculateSumUsingDataService());
	}

}
