package com.bloggapp.services;

import java.util.List;

import com.bloggapp.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user , Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void DeleteUser(Integer userid);
	

}
