package com.akanksha.microservices.limits.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akanksha.microservices.limits.service.bean.Limits;
import com.akanksha.microservices.limits.service.configuration.Configuration;

@RestController
public class LimitsController {

	@Autowired
	private Configuration configuration;
	@GetMapping("/limits")
	public Limits retriveLimits() {
		return new Limits(configuration.getMinimum(),configuration.getMaximum());
		//return new Limits(1,1000);
	}
}
