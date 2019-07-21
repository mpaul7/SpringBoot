package com.springbootunittesting.mockingmockito.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.springboot.unittesting.mockingmockito.business.SomeBusinessImpl;
import com.springboot.unittesting.mockingmockito.data.SomeDataService;


@RunWith(MockitoJUnitRunner.class)
class SomBusinessMockTestWithMockitoAnnotations {
	
	@InjectMocks
	SomeBusinessImpl business;// = new SomeBusinessImpl();
	@Mock
	SomeDataService dataServiceMock;// = mock(SomeDataService.class);

	@Test
	void calculateSumUsingDataService_basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
		business.setSomeDataService(dataServiceMock);
		assertEquals(6, business.calculateSumUsingDataService());
	}

	@Test
	void calculateSumUsingDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		business.setSomeDataService(dataServiceMock);
		assertEquals(0, business.calculateSumUsingDataService());
	}

	@Test
	void calculateSumUsingDataService_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1 });
		business.setSomeDataService(dataServiceMock);
		assertEquals(1, business.calculateSumUsingDataService());
	}

}
