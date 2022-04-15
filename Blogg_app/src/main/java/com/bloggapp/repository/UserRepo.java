package com.bloggapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloggapp.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
