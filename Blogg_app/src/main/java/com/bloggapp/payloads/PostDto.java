package com.bloggapp.payloads;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
	
	private  String postTitle;
	private  String postContent;
	private  String imageUrl;
	private  Date date;
	private  UserDto user;
	private  CategoryDto category;
	
}
