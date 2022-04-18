package com.bloggapp.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int user_id;
	
	@NotEmpty
	@Size(min=4,message="Username must br min of 4 character")
	private String name;
	
	@Email(message="Email is not valid!!")
	private String email;
	
	@NotEmpty
	private String about;
	
	@NotEmpty
	@Size(min=3,max=10,message="password must be min of 3 char and max of 10 char")
	private String password;
	
	
	@Override
	public String toString() {
		return "UserDto [user_id=" + user_id + ", name=" + name + ", email=" + email + ", about=" + about
				+ ", password=" + password + "]";
	}
	
}
