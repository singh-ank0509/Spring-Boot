package com.spring.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.dto.Student;

@RestController
public class ProviderController {

	@GetMapping("/")
	public ResponseEntity<String> welcome() {
		return new ResponseEntity<>("Spring Security Provider Application.", HttpStatus.OK);
	}
	
	@PostMapping("/qwer")
	public ResponseEntity<Student> demoRequestBody(@RequestBody Student std) {
		System.err.println("Student :: " + std);
		return new ResponseEntity<>(std, HttpStatus.OK);
	}
}
