package com.bloggapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bloggapp.payloads.PostDto;
import com.bloggapp.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/user/{userid}/category/{catid}/posts")
	public PostDto createPost(@Valid @RequestBody PostDto postdto ,@PathVariable Integer userid,@PathVariable Integer catid) {
		
		PostDto createPost = this.postService.createPost(postdto, userid, catid);
		return createPost;
	}
	
	@GetMapping("/user/{userid}/posts")
	public List<PostDto> getPostByUser(@PathVariable Integer userid) {
		List<PostDto> postByUser = this.postService.getPostByUser(userid);
		return postByUser;	
	}
	
	@GetMapping("/category/{catid}/posts")
	public List<PostDto> getPostByCategory(@PathVariable Integer catid) {
		List<PostDto> postByCategory = this.postService.getPostByCategory(catid);
		return postByCategory;
	}
	
	@GetMapping("/posts")
	public List<PostDto> getAllPost(){
		List<PostDto> allPost = this.postService.getAllPost();
		return allPost;
	}
}
