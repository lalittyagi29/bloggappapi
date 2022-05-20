package com.bloggapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloggapp.payloads.CommentDto;
import com.bloggapp.services.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/user/{userid}/post/{postid}/comment")
	public CommentDto createComment(@RequestBody CommentDto commentdto,@PathVariable Integer userid,@PathVariable Integer postid) {
		
		CommentDto createComment = this.commentService.createComment(commentdto, userid, postid);
		return createComment;	
	}

}
