package com.ankur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankur.clients.GreetFeignClient;

@RestController
public class GreetController {
	
	@Autowired
	private GreetFeignClient feignClient;

	@GetMapping("/")
	public String welcome() {
		
		String welcomeMsg = feignClient.welcomeApiCall();
		
//		return "Good Morning... Cricketing Fellows!!";
		return "Good Morning ..." + welcomeMsg;
	}
}
