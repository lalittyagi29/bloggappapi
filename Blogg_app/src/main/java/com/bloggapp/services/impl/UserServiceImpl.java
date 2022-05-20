package com.bloggapp.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloggapp.entities.User;
import com.bloggapp.exceptions.ResourceNotFoundException;
import com.bloggapp.payloads.UserDto;
import com.bloggapp.repository.UserRepo;
import com.bloggapp.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userdto) {

		User user = this.dtoTUser(userdto);
		User savedUser = this.userRepo.save(user);
		return this.UserToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userdto, Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		user.setName(userdto.getName());
		user.setAbout(userdto.getAbout());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		User updatedUser = this.userRepo.save(user);
		return this.UserToDto(updatedUser);
	}

	@Override
	public UserDto getUserById(Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		return this.UserToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> users = this.userRepo.findAll();
		List<UserDto> userdtos = users.stream().map(user -> this.UserToDto(user)).collect(Collectors.toList());
		return userdtos;
	}

	@Override
	public void DeleteUser(Integer userid) {

		User user=this.userRepo.findById(userid).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userid));
		this.userRepo.delete(user);
	}

	public User dtoTUser(UserDto userDto) {

		User user = this.modelMapper.map(userDto, User.class);
//		user.setUser_id(userDto.getUser_id());
//		user.setAbout(userDto.getAbout());
//		user.setEmail(userDto.getEmail());
//		user.setName(userDto.getName());
//		user.setPassword(userDto.getPassword());
    	return user;
		
		
	}

	public UserDto UserToDto(User user) {

		UserDto userDto = this.modelMapper.map(user, UserDto.class);
//		userDto.setAbout(user.getAbout());
//		userDto.setEmail(user.getEmail());
//		userDto.setName(user.getName());
//		userDto.setPassword(user.getPassword());
//		userDto.setUser_id(user.getUser_id());
		return userDto;
	}
}
