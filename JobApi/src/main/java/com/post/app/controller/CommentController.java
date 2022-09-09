package com.post.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.post.app.dto.UpdateComment;
import com.post.app.dto.UserCommentOnJobPostDto;
import com.post.app.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping("/postComment/{userId}/{postId}")
	public UserCommentOnJobPostDto postComment(
			@PathVariable("userId") Integer userId,
			@PathVariable("postId") Integer postId,@RequestBody UserCommentOnJobPostDto userCommentOnJobPostDto) {
		
		UserCommentOnJobPostDto userComment=commentService.postComment(userId,postId,userCommentOnJobPostDto);
		return userComment;
	}
	
	@PutMapping("updateComment/{commentId}")
	public UserCommentOnJobPostDto updateComment(@PathVariable("commentId") Integer commentId,@RequestBody UpdateComment updatedComment) {
		
		UserCommentOnJobPostDto UpdatedComment=commentService.updateComment(commentId,updatedComment);
		return UpdatedComment;
	}
}

