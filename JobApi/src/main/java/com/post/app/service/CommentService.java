package com.post.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.app.dto.JobPostDto;
import com.post.app.dto.UpdateComment;
import com.post.app.dto.UserCommentOnJobPostDto;
import com.post.app.entity.JobPost;
import com.post.app.entity.UserCommentOnJobPost;
import com.post.app.repositories.JobPostRepo;
import com.post.app.repositories.UserCommentOnJobPostRepo;

@Service
public class CommentService {
	@Autowired
	private JobPostRepo jobPostRepo;
	
	@Autowired
	private UserCommentOnJobPostRepo userCommentOnJobPostRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	public UserCommentOnJobPostDto postComment(Integer userId, Integer postId,
			UserCommentOnJobPostDto userCommentOnJobPostDto) {
		
		JobPost updatePost=jobPostRepo.findById(postId).get();
		JobPostDto jobPostDto =modelMapper.map(updatePost, JobPostDto.class);
		UserCommentOnJobPostDto UserCommentOnJobPost= new UserCommentOnJobPostDto();
		UserCommentOnJobPost.setJobPost(jobPostDto);
		UserCommentOnJobPost.setContent(userCommentOnJobPostDto.getContent());
		UserCommentOnJobPost.setUserId(userId);
		UserCommentOnJobPost postWithCommentForSave =modelMapper.map(UserCommentOnJobPost, UserCommentOnJobPost.class);
		userCommentOnJobPostRepo.save(postWithCommentForSave);
		
		return modelMapper.map(postWithCommentForSave, UserCommentOnJobPostDto.class);
	}

	public UserCommentOnJobPostDto updateComment(Integer commentId, UpdateComment updatedComment) {
		
		UserCommentOnJobPost updatedCommentwithPost=userCommentOnJobPostRepo.findById(commentId).get();
		updatedCommentwithPost.setContent(updatedComment.getContent());
		userCommentOnJobPostRepo.save(updatedCommentwithPost);
		return modelMapper.map(updatedCommentwithPost, UserCommentOnJobPostDto.class);
	}

	
}
