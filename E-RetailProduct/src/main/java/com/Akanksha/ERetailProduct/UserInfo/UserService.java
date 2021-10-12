package com.Akanksha.ERetailProduct.UserInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class UserService {
	@Autowired
	UserRepository userRep;
	
	
	public List<User> fetchAllUsers(){
		return userRep.findAll();
	}
	
	public User fetchUserById(int id) {
		List<User> users=userRep.findAll();
		User user=null;
		
		for(User i:users) {
			if(i.getUserId()==id)
				user=i;
		}
		return user;
	}
	
	public User fetchUserByName(String name) {
		List<User> users=userRep.findAll();
		User user=null;
		
		
		for(User i:users) {
			if(i.getUserName().equalsIgnoreCase(name))
				user=i;
		}
		return user;
	}
	
	public User addUser(User user) {
		
		int id=getMaxId();
		user.setUserId(id);
		userRep.save(user);
		userRep.getById(id);
 		return user;
	}
	
	public int getMaxId() {
		return userRep.findAll().size()+1;
	}
	
	public User updateUser(User user) {
		userRep.save(user);
		return user;
	}
	
	public void deleteUser(User user) {
		userRep.delete(user);
	}
}
