package com.Akanksha.ERetailProduct.UserInfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="userlist")
public class User {
	
	@Id
	@Column(name="userid")
	private int userID;
	
	@Column(name="username")
	@NotNull(message="userName should not be null or blank please enter valid user name!")
	@Size(min=2,message="product name should be atleast 2 characters")
	private String userName;
	
	@Column(name="email")
	@Email(message="Please enter valid email address")
	private String email;
	
	public User() {
		super();
	}

	public User(int userId, String name, String email) {
		super();
		this.userID = userId;
		this.userName = name;
		this.email = email;
	}

	public int getUserId() {
		return userID;
	}


	public void setUserId(int userId) {
		this.userID = userId;
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String name) {
		this.userName = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	

}
