package com.Akanksha.RestFulWebservices.versioning;

public class Person {
	private String name;
	
	public Person() {
		super();
	}

	/**
	 * @param name
	 */
	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
