package com.post.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.post.app.dto.JobPostDto;
import com.post.app.dto.UpdatePost;
import com.post.app.entity.CandidateEligibility;
import com.post.app.entity.Company;
import com.post.app.entity.JobPost;
import com.post.app.exceptions.ResourceNotFoundException;
import com.post.app.repositories.CompanyRepo;
import com.post.app.repositories.JobPostRepo;

@Service
public class JobPostService {
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Autowired
	private JobPostRepo jobPostRepo;
	
	@Autowired
	private CompanyRepo compayRepo;
	
	public JobPostDto postJob(JobPostDto jobPostDto) {
		JobPost jobPost =modelMapper.map(jobPostDto, JobPost.class);
		jobPost.setPostedDate(java.time.LocalDate.now());
		JobPost jobposted = jobPostRepo.save(jobPost);
		return modelMapper.map(jobposted, JobPostDto.class);
	}
	//*******************************************************************
	public JobPostDto JobPostToJobPostDto(JobPost jobPost) {
		JobPostDto jobPostDto =modelMapper.map(jobPost, JobPostDto.class);
		return jobPostDto;
	}
	
	public JobPost jobPostDtoTojobPost(JobPostDto jobPostDto) {
		JobPost jobPost =modelMapper.map(jobPostDto, JobPost.class);
		return jobPost;
	}
	//*******************************************************************

	public JobPostDto postJobWithCompanyId(Integer companyId, JobPostDto jobPostDto) {
		Company company = compayRepo.findById(companyId).get();
		JobPost jobPost =new JobPost();
		jobPost.setTitle(jobPostDto.getTitle());
		jobPost.setJobTitle(jobPostDto.getJobTitle());
		jobPost.setJobDescription(jobPostDto.getJobDescription());
		jobPost.setJobType(jobPostDto.getJobType());
		jobPost.setSalary(jobPostDto.getSalary());
		jobPost.setLocation(jobPostDto.getLocation());
		jobPost.setPostedDate(java.time.LocalDate.now());
		jobPost.setDriveLocation(jobPostDto.getDriveLocation());
		CandidateEligibility candidateEligibility=new CandidateEligibility();
		candidateEligibility.setSkills(jobPostDto.getCandidateEligibility().getSkills());
		candidateEligibility.setWorkExperience(jobPostDto.getCandidateEligibility().getWorkExperience());
		candidateEligibility.setQualification(jobPostDto.getCandidateEligibility().getQualification());
		jobPost.setCandidateEligibility(candidateEligibility);
		jobPost.setCompany(company);
		
		JobPost jobposted = jobPostRepo.save(jobPost);
		return modelMapper.map(jobposted, JobPostDto.class);
	}
	
	public JobPostDto updatePost(Integer postId, UpdatePost updatePost) {
		JobPost jobPost= jobPostRepo.findById(postId).get();
		
		jobPost.setDriveLocation(updatePost.getDriveLocation());
		jobPost.setJobDescription(updatePost.getJobDescription());
		jobPost.setJobTitle(updatePost.getJobTitle());
		jobPost.setJobType(updatePost.getJobType());
		jobPost.setLocation(jobPost.getLocation());
		jobPost.setPostedDate(java.time.LocalDate.now());
		jobPost.setSalary(updatePost.getSalary());
		jobPost.setTitle(updatePost.getTitle());
		
		return JobPostToJobPostDto(jobPost);
	}
	
	
	public void deleteJobPost(Integer jobPostId) {
		jobPostRepo.deleteById(jobPostId);
	}
	
	public JobPostDto getJobPostById(Integer jobPostId) {
		JobPost jobPost= jobPostRepo.findById(jobPostId).orElseThrow(()->new ResourceNotFoundException("job", "id", jobPostId));
		return JobPostToJobPostDto(jobPost);
	}
	public List<JobPostDto> findAllJobPost() {
		List<JobPost> allPost =jobPostRepo.findAll();
		List<JobPostDto> getAllPost= allPost.stream().map(jobPost->JobPostToJobPostDto(jobPost)).collect(Collectors.toList());
		return getAllPost;
	}

}





















