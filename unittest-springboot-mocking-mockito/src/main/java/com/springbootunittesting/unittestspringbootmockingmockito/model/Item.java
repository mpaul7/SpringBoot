package com.springbootunittesting.unittestspringbootmockingmockito.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Item {
	
	@Id
	public int id;
	public String name;
	public int price;
	public int quantity;
	
	@Transient
	
	private int value;
	
	
	public Item() {
		super();
	}


	public Item(int id, String name, int price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return String.format("Item[%d, %s, %d, %d, %d]",  id, name, price, quantity, value);
	}

	

}
