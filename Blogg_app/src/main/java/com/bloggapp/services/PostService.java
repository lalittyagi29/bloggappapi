package com.bloggapp.services;

import java.util.List;

import com.bloggapp.payloads.PostDto;

public interface PostService {

	PostDto createPost(PostDto postdto,Integer userid,Integer categoryid);
	PostDto updatePost(PostDto postdto,Integer postid);
	List<PostDto> getAllPost();
	PostDto getPostById(Integer postid);
	void deletePostByid(Integer postid);
	List<PostDto> getPostByUser(Integer userid);
	List<PostDto> getPostByCategory(Integer categoryId);
	List<PostDto> searchPostByKeyword(String Keyword);
	
}
