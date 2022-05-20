package com.bloggapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloggapp.entities.Comment;


public interface CommentRepo extends JpaRepository<Comment, Integer> {
	

}
