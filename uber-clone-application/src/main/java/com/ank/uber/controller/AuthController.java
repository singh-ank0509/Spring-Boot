package com.ank.uber.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ank.uber.dtos.SignUpDto;
import com.ank.uber.dtos.UserDto;
import com.ank.uber.services.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;
	
	@PostMapping("/signup")
	public UserDto signUpUser(@RequestBody SignUpDto signUpDto) {
		return authService.signUp(signUpDto);
	}
}
