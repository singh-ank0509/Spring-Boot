package com.ank.uber.dtos;

import java.util.Set;

import com.ank.uber.enums.Roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private String name;  
	private String email;
	private String password;
	private Set<Roles> roles;
}
