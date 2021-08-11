package com.Akanksha.RestFulWebservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users=new ArrayList<>();
	private static int userCount=3;
	
	static {
		users.add(new User(1,"Akanksha",new Date()));
		users.add(new User(2,"Kajal",new Date()));
		users.add(new User(3,"Mangesh",new Date()));
	}
	/**
	 * 
	 * @return list of users
	 */
	public List<User> findAll(){
		return users;
	}
	
	/**
	 * 
	 * @param user
	 * @return object of User class
	 * This method is for adding new user to the existing list
	 */
	public User save(User user) {
		
		if(user.getId()==null) {
			
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	/**
	 * 
	 * @param id
	 * @return object of User class 
	 * This method is returning user which id is same as client requested.
	 */
	public User findOne(int id) {
		
		for(User user:users) {
			
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	

}
