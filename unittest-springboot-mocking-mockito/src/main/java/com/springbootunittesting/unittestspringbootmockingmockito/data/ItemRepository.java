package com.springbootunittesting.unittestspringbootmockingmockito.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootunittesting.unittestspringbootmockingmockito.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
