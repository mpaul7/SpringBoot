package com.user.webservices.userwebservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private int userCount = 3;
	
	private static List<User> users = new ArrayList<>();
	
	/**
	 * Create a static block to populate List
	 */
 
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}
	
	/**
	 * Create methods to 
	 * - return all the users
	 * - create/save a new user
	 * - return a specific user
	 */
	
	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user: users){
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
}

