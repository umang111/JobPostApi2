package com.post.app.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePost {

	private int jobId;
	private String title;
	private String jobTitle;
	private String jobDescription;
	private String jobType;
	private String salary;
	private String location;
	private Date postedDate; 
	private String driveLocation;
}
