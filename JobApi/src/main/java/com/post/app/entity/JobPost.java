package com.post.app.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="jobpost")
public class JobPost {

	@Id
	@GeneratedValue
	private int jobId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="job_type")
	private String jobType;
	
	@Column(name="salary")
	private String salary;
	
	@Column(name="location")
	private String location;
	
	@Column(name="posted_date")
	private LocalDate postedDate; 
	
	@Column(name="drive_location")
	private String driveLocation;
	
	@Embedded
	private CandidateEligibility candidateEligibility; 
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Company company;
	
	@OneToMany(mappedBy="jobPost",cascade=CascadeType.ALL)
	private List<UserCommentOnJobPost> comment;
}






