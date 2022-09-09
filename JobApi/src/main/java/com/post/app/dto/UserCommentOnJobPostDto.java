package com.post.app.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCommentOnJobPostDto {

    private int comment_id;
    
    @NotEmpty
	private int userId;

    @NotEmpty
	private String content;

	private JobPostDto jobPost;
	
}
