package com.springbootunittesting.unittestspringbootmockingmockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.springbootunittesting.unittestspringbootmockingmockito.business.ItemBusinessService;
import com.springbootunittesting.unittestspringbootmockingmockito.data.ItemRepository;
import com.springbootunittesting.unittestspringbootmockingmockito.model.Item;

@RunWith(MockitoJUnitRunner.class)
class ItemBusinessServiceTest {
	
	@InjectMocks
	private ItemBusinessService business;
	
	@Mock
	private ItemRepository repository;
	
	@Test
	public void calculateSumUsingDataService_basic() {
		when(repository.findAll()).thenReturn(Arrays.asList((
				new Item(2, "Item2", 10, 10)), 
				new Item(3, "Item3", 20, 20)));
		List<Item> items = business.retrieveAllItems();
		assertEquals(100, items.get(0).getValue());
		assertEquals(400, items.get(1).getValue());
	}
}
