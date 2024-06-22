package com.ankur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {
	
	@Autowired
	private Environment env;

	@GetMapping("/")
	public String welcome() {
		
		String port = env.getProperty("server.port");
		
		return "Welcome To Microservices Learning...(" + port + ")";
	}
}
