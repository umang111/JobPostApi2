package com.post.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.post.app.entity.UserCommentOnJobPost;

public interface UserCommentOnJobPostRepo extends JpaRepository<UserCommentOnJobPost,Integer>{

}
