package com.example.demo;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppConfiguration implements ErrorController{
	private static final String PATH = "/error";
	
	@GetMapping(value="/")
	public String hello() {
		return "Hello Akanksha";
	}
	public String error() {
        return "Error handling";
    }

    //@Override
    public String getErrorPath() {
        return PATH;
    }
}
