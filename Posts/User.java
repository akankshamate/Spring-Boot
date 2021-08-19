package com.Akanksha.RestFulWebservices;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.Akanksha.RestFulWebservices.Posts.Post;
/**
 * 
 * @author akanksha
 * {@code User} class have getter and setter methods which will retrieve and setting the 
 * information about users. 
 *
 */
//@ApiModel(description="All details about user")
@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2,message="Name must be atleast 2 characters ")
	private String name;
	
	@Past
	private Date birthDate;
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	
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
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
}
