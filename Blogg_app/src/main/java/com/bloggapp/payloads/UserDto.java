package com.bloggapp.payloads;

import javax.validation.constraints.Email;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int user_id;
	
	@NotNull
	private String name;
	
	@Email
	private String email;
	
	private String about;
	
	@NotNull
	private String password;
	
	
	@Override
	public String toString() {
		return "UserDto [user_id=" + user_id + ", name=" + name + ", email=" + email + ", about=" + about
				+ ", password=" + password + "]";
	}
	
}
