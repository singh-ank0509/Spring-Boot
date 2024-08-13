package com.ank.uber.services.impl;

import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ank.uber.dtos.DriverDto;
import com.ank.uber.dtos.SignUpDto;
import com.ank.uber.dtos.UserDto;
import com.ank.uber.entities.User;
import com.ank.uber.enums.Roles;
import com.ank.uber.exception.RuntimeConflictException;
import com.ank.uber.repository.UserRepository;
import com.ank.uber.services.AuthService;
import com.ank.uber.services.RiderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	private final ModelMapper modelMapper;
	private final UserRepository userRepository;
	private final RiderService riderService;
	
	@Override
	public String login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto signUp(SignUpDto signUpDto) {
		Optional<User> isUserExist = userRepository.findByEmail(signUpDto.getEmail());
		if(isUserExist.isPresent()) {
			throw new RuntimeConflictException("Email already exists!!");
		}
		
		User user = modelMapper.map(signUpDto, User.class);
		user.setRoles(Set.of(Roles.RIDER));
		User savedUser = userRepository.save(user);
		
		// create rider repository
		riderService.createNewRider(savedUser);
		
		// TODO Wallet related implementation 
		
		return modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public DriverDto onboardNewDriver(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
