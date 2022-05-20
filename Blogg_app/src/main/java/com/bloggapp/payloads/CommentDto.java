package com.bloggapp.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CommentDto {
	
	private int cid;
	private String content;
	private UserDto user;
	private PostDto post;

}
