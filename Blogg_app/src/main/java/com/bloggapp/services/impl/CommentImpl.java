package com.bloggapp.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloggapp.entities.Comment;
import com.bloggapp.entities.Post;
import com.bloggapp.entities.User;
import com.bloggapp.exceptions.ResourceNotFoundException;
import com.bloggapp.payloads.CommentDto;
import com.bloggapp.repository.CommentRepo;
import com.bloggapp.repository.PostRepo;
import com.bloggapp.repository.UserRepo;
import com.bloggapp.services.CommentService;

@Service
public class CommentImpl implements CommentService {

	@Autowired
	private CommentRepo commneRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	@Override
	public CommentDto createComment(CommentDto commentdto,Integer userid,Integer postid) {
		
		User user = this.userRepo.findById(userid).orElseThrow(()->new ResourceNotFoundException("User", "userid", userid));
		Post post = this.postRepo.findById(postid).orElseThrow(()->new ResourceNotFoundException("post", "postid", postid));
		Comment comment = this.modelMapper.map(commentdto, Comment.class);
		comment.setUser(user);
		comment.setPost(post);
        Comment saveComment = this.commneRepo.save(comment);
        CommentDto savecommentdto = this.modelMapper.map(saveComment, CommentDto.class);
		return savecommentdto;
	}

}
