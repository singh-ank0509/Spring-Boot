package com.ankur.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@Value("${msg}")
	private String msgtext;
	
	@GetMapping("/greet")
	public String getGreetMessage() {
		return msgtext;
	}
}