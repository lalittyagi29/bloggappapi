package com.bloggapp.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloggapp.entities.Category;
import com.bloggapp.entities.Post;
import com.bloggapp.entities.User;
import com.bloggapp.exceptions.ResourceNotFoundException;
import com.bloggapp.payloads.PostDto;
import com.bloggapp.repository.CategoryRepo;
import com.bloggapp.repository.PostRepo;
import com.bloggapp.repository.UserRepo;
import com.bloggapp.services.PostService;

@Service
public class PostImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	
	@Override
	public PostDto createPost(PostDto postdto,Integer userid,Integer categoryid) {
		
		Post post = this.modelMapper.map(postdto, Post.class);
		User user = this.userRepo.findById(userid).orElseThrow(()->new ResourceNotFoundException("User", "Userid", userid));
		Category category = this.categoryRepo.findById(categoryid).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", categoryid));
		post.setDate(new Date());
		post.setImageUrl("dafault.png");
		post.setUser(user);
		post.setCategory(category);
		Post newpost=this.postRepo.save(post);
		PostDto newpostdto = this.modelMapper.map(newpost, PostDto.class);
		return newpostdto;
	}

	@Override
	public PostDto updatePost(PostDto postdto, Integer postid) {
		
		Post oldpost = this.postRepo.findById(postid).orElseThrow(()->new ResourceNotFoundException("post","postid" , postid));
		oldpost.setCategory(null);
		oldpost.setDate(null);
		oldpost.setImageUrl(null);
		oldpost.setPostContent(null);
		oldpost.setPostTitle(null);
		oldpost.setUser(null);
		return null;
	}

	@Override
	public List<PostDto> getAllPost() {
		List<Post> allposts = this.postRepo.findAll();
		List<PostDto> postsdto = allposts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postsdto;
	}

	@Override
	public PostDto getPostById(Integer postid) {
		
		Post post = this.postRepo.findById(postid).orElseThrow(()->new ResourceNotFoundException("post", "postid", postid));
		PostDto postdto = this.modelMapper.map(post, PostDto.class);
		return postdto;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userid) {
		
		User user = this.userRepo.findById(userid).orElseThrow(()->new ResourceNotFoundException("User", "userid", userid));
		List<Post> posts = this.postRepo.findByUser(user);
		List<PostDto> postdto = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postdto;
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "categoryId", categoryId));
		List<Post> posts = this.postRepo.findByCategory(category);
		List<PostDto> postdto = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postdto;
	}

	@Override
	public List<PostDto> searchPostByKeyword(String Keyword) {
		
		return null;
	}

	@Override
	public void deletePostByid(Integer postid) {
		
		Post post = this.postRepo.findById(postid).orElseThrow(()->new ResourceNotFoundException("post", "postid", postid));
		this.postRepo.deleteById(postid);
		
	}
	
}
