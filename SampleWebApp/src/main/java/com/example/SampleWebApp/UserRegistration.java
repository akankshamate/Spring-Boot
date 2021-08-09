package com.example.SampleWebApp;

import java.util.Arrays;
/**
 * 
 * @author akanksha
 * {@code UserRegistration} class have some information about user details in particular instance variable   
 *
 */
public class UserRegistration {
	private String UName;
	private String EmailId;
	private String Password;
	private byte Gender;
	private String[] Hobby;
	
	/**
	 * 
	 * @return user name
	 */
	public String getUName() {
		return UName;
	}
	
	/**
	 * 
	 * @param uName 
	 * setting value to the instance variable UName
	 */
	public void setUName(String uName) {
		UName = uName;
	}
	
	/**
	 * 
	 * @return email id of user
	 */
	public String getEmailId() {
		return EmailId;
	}
	
	/**
	 * 
	 * @param emailId
	 * setting value to the instance variable EmailId
	 */
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	
	/**
	 * 
	 * @return password of the user.
	 */
	public String getPassword() {
		return Password;
	}
	
	/**
	 * 
	 * @param password 
	 * setting value to the instance variable Password
	 */
	public void setPassword(String password) {
		Password = password;
	}
	
	/**
	 * 
	 * @return gender of the user male or female
	 */
	public byte getGender() {
		return Gender;
	}
	
	/**
	 * 
	 * @param gender
	 * setting value to the instance variable Gender
	 */
	public void setGender(byte gender) {
		Gender = gender;
	}
	
	/**
	 * 
	 * @return entered hobbies of a user through the string array 
	 */
	public String[] getHobby() {
		return Hobby;
	}
	
	/**
	 * 
	 * @param hobby
	 * setting value to the instance variable Hobby which is String array
	 */
	public void setHobby(String[] hobby) {
		this.Hobby = hobby;
	}
	
	@Override
	public String toString() {
		return "UserRegistration [UName=" + UName + ", EmailId=" + EmailId + ", Password=" + Password + ", Gender="
				+ Gender + ", Hobby=" + Arrays.toString(Hobby) + "]";
	}
}
