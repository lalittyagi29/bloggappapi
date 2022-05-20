package com.bloggapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloggapp.entities.Category;
import com.bloggapp.entities.Post;
import com.bloggapp.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post>  findByUser(User user);
	List<Post>  findByCategory(Category category);

}
