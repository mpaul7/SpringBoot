package com.springbootunittesting.mockingmockito.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.springboot.unittesting.mockingmockito.business.SomeBusinessImpl;
import com.springboot.unittesting.mockingmockito.data.SomeDataService;



class SomBusinessTest {

	@Test
	void calculateSum_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {1, 2, 3});
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void calculateSum_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void calculateSum_one() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {1});
		int expectedResult = 1;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		/**
		 * Here the SomeDataService will be talking to Database.
		 * But in Testing units, it is not required.
		 * So we create a Stub of SomeDataService.
		 * 
		 */
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

}
