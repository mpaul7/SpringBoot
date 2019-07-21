package com.springbootunittesting.unittestspringbootmockingmockito.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springbootunittesting.unittestspringbootmockingmockito.model.Item;

@RunWith(SpringRunner.class)
@DataJpaTest
class ItemRepositoryTest {
	
	@Autowired
	ItemRepository repository;

	@Test
	public void testFindAll() {
		List<Item> items = repository.findAll();
		assertEquals(3, items.size());
	}

}
