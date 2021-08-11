package com.Akanksha.RestFulWebservices;

import java.util.Date;
/**
 * 
 * @author akanksha
 * {@code User} class have getter and setter methods which will retrieve and setting the 
 * information about users. 
 *
 */
public class User {
	private Integer id;
	private String name;
	private Date birthDate;
	
	public User() {
		
	}
	/**
	 * @param id
	 * @param name
	 * @param birthDate
	 */
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	/**
	 * 
	 * @return id of the user
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id intializes id variable of a class
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return name of the user
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name
	 * setting value for the instance variable name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return birthDate of the user
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	
	/**
	 * 
	 * @param birthDate
	 * setting value for the instance variable birthDate
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
}
