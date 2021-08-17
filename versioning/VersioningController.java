package com.Akanksha.RestFulWebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {
	
	@GetMapping("v1/person")
	public Person person() {
		return new Person("Akanksha Mate");
	}
	@GetMapping("v2/person")
	public Person2 person2() {
		return new Person2(new Name("Akanksha","Mate"));
	}
	@GetMapping(value="/person/param",params="version=1")
	public Person param() {
		return new Person("Akanksha Mate");
	}
	@GetMapping(value="/person/param",params="version=2")
	public Person2 param2() {
		return new Person2(new Name("Akanksha","Mate"));
	}
	@GetMapping(value="/person/header",headers="X-API-VERSION=1")
	public Person header() {
		return new Person("Akanksha Mate");
	}
	@GetMapping(value="/person/header",headers="X-API-VERSION=2")
	public Person2 header2() {
		return new Person2(new Name("Akanksha","Mate"));
	}
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v1+json")
	public Person produces() {
		return new Person("Akanksha Mate");
	}
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v2+json")
	public Person2 produces2() {
		return new Person2(new Name("Akanksha","Mate"));
	}
}
