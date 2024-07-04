package com.ankur.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Value("${msg}")
	private String msgtext;
	
	@GetMapping("/welcome")
	public String getWelcomeMessage() {
		return msgtext;
	}
}
