package com.bloggapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bloggapp.payloads.ApiResponse;
import com.bloggapp.payloads.UserDto;
import com.bloggapp.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UesrController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userdto) {

		UserDto CreateduserDto = this.userService.createUser(userdto);
		return new ResponseEntity<>(CreateduserDto, HttpStatus.CREATED);

	}

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser() {

		return ResponseEntity.ok(this.userService.getAllUsers());
	}

	@GetMapping("/{userid}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userid) {

		UserDto userbyid = this.userService.getUserById(userid);
		return ResponseEntity.ok(userbyid);

	}

	@DeleteMapping("/{userid}")
	public ResponseEntity<ApiResponse> DeleteUser(@PathVariable Integer userid) {

		this.userService.DeleteUser(userid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Sucessfully", true), HttpStatus.OK);

	}

	@PutMapping("/{userid}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userid) {

		UserDto updateduser = this.userService.updateUser(userDto, userid);
		return ResponseEntity.ok(updateduser);
	}

}
