package com.post.app.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostDto {
	
	private int jobId;
	private String title;
	private String jobTitle;
	private String jobDescription;
	private String jobType;
	private String salary;
	private String location;
	private LocalDate postedDate; 
	private String driveLocation;
	
	private CandidateEligibilityDto candidateEligibility; 
	
	private CompanyDto company;
}
