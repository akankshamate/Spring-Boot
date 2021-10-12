package com.Akanksha.ERetailProduct.UserInfo;

import java.util.List;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Akanksha.ERetailProduct.ExceptionHandling.UserNotFoundException;

@RestController
@RequestMapping("/e-retail")
@Validated
//@ControllerAdvice(annotations = RestController.class)
public class UserController {
	@Autowired
	UserService userService;
	
	
	@GetMapping("/fetchusers")
	public ResponseEntity<List<User>> fetchUsers(){
		try {
			List<User> users=userService.fetchAllUsers();
			return new ResponseEntity<List<User>>(users,HttpStatus.FOUND);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/fetchuser/{id}")
	public ResponseEntity<User> fetchUserById(@PathVariable(value="id") int id){
		
			User user=userService.fetchUserById(id);
			if (user==null)
			      throw new UserNotFoundException("id-" + id);
			else
				return new ResponseEntity<User>(user,HttpStatus.FOUND);
	}
	
	@GetMapping("/fetchuser/userName")
	public ResponseEntity<User> fetchUserByName(@RequestParam(value="name")  String userName){
		
			User user=userService.fetchUserByName(userName);
			if (user==null)
			      throw new UserNotFoundException("name-" + userName);
			else
				return new ResponseEntity<User>(user,HttpStatus.FOUND);
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<User> addUser( @Valid @RequestBody User user) {
		try {
		    user=userService.addUser(user);
			return new ResponseEntity<User>(user,HttpStatus.CREATED);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/edituser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value="id") int userId ,
										 @Valid @RequestBody User user) {
		
			User existUser=userService.fetchUserById(userId);
			if(existUser==null)
				throw new UserNotFoundException("id-" + userId);
			else {
				existUser.setUserName(user.getUserName());
				existUser.setEmail(user.getEmail());
			
				User update_user=userService.updateUser(existUser);
				return new ResponseEntity<User>(update_user,HttpStatus.OK);
			}
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value="id") int id) {
		User user=null;
		user=userService.fetchUserById(id);
		
		if(user==null)
			throw new UserNotFoundException("id-" + id);
		else {
			userService.deleteUser(user);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
	}
}

