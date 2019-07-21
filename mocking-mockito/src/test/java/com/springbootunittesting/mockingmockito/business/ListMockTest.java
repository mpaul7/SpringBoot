package com.springbootunittesting.mockingmockito.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;

import java.awt.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class ListMockTest {
	List mockList = mock(List.class);

	@Test
	void size_basic() {
		when(mockList.getSize()).thenReturn(5);
		assertEquals(5, mockList.getSize());
	}

	@Test
	void returnDifferentValues() {
		when(mockList.getSize()).thenReturn(5).thenReturn(10);
		assertEquals(5, mockList.getSize());
		assertEquals(10, mockList.getSize());
	}
	
	@Test
	void returnWithParameters() {
		when(mockList.get(0)).thenReturn("mpaul");
		assertEquals("mpaul", mockList.get(0));
		assertEquals(null, mockList.get(1));
	}
	
	@Test
	void returnWithGenericParameters() {
		when(mockList.get(anyInt())).thenReturn("mpaul");
		assertEquals("mpaul", mockList.get(0));
		assertEquals("mpaul", mockList.get(1));
	}
	
	@Test
	public void verificationBasics() {
		String value = mockList.get(0);
		verify(mockList.get(0));
		verify(mockList, times(2)).get(anyInt());
		verify(mockList, atLeast(1)).get(anyInt());
		verify(mockList, atLeastOnce()).get(anyInt());
		verify(mockList, atMost(2)).get(anyInt());
		verify(mockList, never()).get(2);
		
	}
	
	@Test
	public void argumentCapturing() {
		
		//SUT
		mockList.add("mpaul");
		
		//verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mockList).add(captor.capture());
		assertEquals("mpaul", captor.getValue());
		
	}
	
	@Test
	public void multipleArgumentCapturing() {
		
		//SUT
		mockList.add("mpaul1");
		mockList.add("mpaul2");
		
		//verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mockList, times(2)).add(captor.capture());
		List<String> allValues = captor.getAllValues();
		assertEquals("mpaul1", allValue().get(0));
		assertEquals("mpaul2", allValue().get(1));
		
		assertEquals("mpaul", captor.getValue());
		
	}
	
	@Test
	public void mocking() {
		ArrayList arrayListMock = mock(ArrayList.class);
		arrayListMock.get(0); // null
		arrayListMock.size(); // 0
		arrayListMock.add("Test");
		arrayListMock.add("Test2");
		arrayListMock.size(); // 0
		
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());
		
	}
	
	@Test
	public void spying() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		arrayListSpy.get(0); // null
		arrayListSpy.size(); // 0
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		arrayListSpy.size(); // 0
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());
		
	}
	
	
}
