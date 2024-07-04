package com.spring.security.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.security.dto.Student;

@RestController
public class ConsumerController {
	
	@Autowired
	private RestTemplate rt;

	@GetMapping("/")
	public String welcome() {
		String baseUrl = "http://localhost:8081/";
		
		HttpHeaders hdr = new HttpHeaders();
		hdr.setBasicAuth("ankur", "ankur@0509");
		
		HttpEntity<String> entity = new HttpEntity<>(hdr);
		
		ResponseEntity<String> response = rt.exchange(baseUrl, HttpMethod.GET, entity, String.class);
		System.err.println("Response : " + response.getBody());
		return response.getBody();
	}
	
	@GetMapping("/body")
	public String requestBodyDemo() {
		String baseUrl = "http://localhost:8081/qwer";
		
//		HttpHeaders hdr = new HttpHeaders();
//		hdr.setBasicAuth("ankur", "ankur@0509");
		
		String credentials = "ankur:ankur@123";
	    String basicAuth = "Basic " + new String(Base64.getEncoder().encode(credentials.getBytes()));
	    
	    HttpHeaders hdr = new HttpHeaders();
	    hdr.setContentType(MediaType.APPLICATION_JSON);
	    hdr.add("Authorization", basicAuth);
		
		Student std = new Student();
		std.setId("101");
		std.setName("ankur");
		
		HttpEntity<Object> entity = new HttpEntity<>(std, hdr);
		System.err.println("Body : " + entity.getBody());
		
		ResponseEntity<String> response = rt.exchange(baseUrl, HttpMethod.POST, entity, String.class);
		System.err.println("Response : " + response.getBody());
		return response.getBody();
	}
	
	@GetMapping("/body-obj")
	public Student requestBodyDemoObject() {
		String baseUrl = "http://localhost:8081/qwer";
		
		HttpHeaders hdr = new HttpHeaders();
		hdr.setBasicAuth("singh", "singh@123");
		
		Student std = new Student();
		std.setId("1000001");
		std.setName("ankur singh");
		
		HttpEntity<Object> entity = new HttpEntity<>(std, hdr);
		System.err.println("Body : " + entity.getBody());
		
		ResponseEntity<Student> response = rt.exchange(baseUrl, HttpMethod.POST, entity, Student.class);
		System.err.println("Response : " + response.getBody());
		return response.getBody();
	}
}
