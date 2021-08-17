package com.Akanksha.RestFulWebservices.versioning;

public class Person2 {
	private Name name;

	public Person2() {
		super();
	}

	/**
	 * @param name
	 */
	public Person2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
	
}
