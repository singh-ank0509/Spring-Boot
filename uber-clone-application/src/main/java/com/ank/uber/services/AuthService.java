package com.ank.uber.services;

import com.ank.uber.dtos.DriverDto;
import com.ank.uber.dtos.SignUpDto;
import com.ank.uber.dtos.UserDto;

public interface AuthService {
	
	String login(String email, String password);
	
	UserDto signUp(SignUpDto dto);
	
	DriverDto onboardNewDriver(Long userId);
}
