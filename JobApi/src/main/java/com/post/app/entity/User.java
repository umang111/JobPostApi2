package com.post.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId; 
	
	private String userName;
	private String userEmail;
	private String userPassword;
	private String workExperience;
	
}
