package com.post.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_comment")

public class UserCommentOnJobPost {

	@Id
	@GeneratedValue
	private int comment_id;
	
	@Column(name="user_id")
	private int userId;
	
	private String content;
	
	@ManyToOne()
	private JobPost jobPost;
	
}
