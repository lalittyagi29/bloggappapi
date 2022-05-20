package com.bloggapp.services;

import com.bloggapp.payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto comment,Integer userid,Integer postid);

}
