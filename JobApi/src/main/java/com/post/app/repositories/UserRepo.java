package com.post.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.post.app.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
