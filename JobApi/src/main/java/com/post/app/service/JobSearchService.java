package com.post.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.app.dto.JobPostDto;
import com.post.app.entity.JobPost;
import com.post.app.repositories.JobPostRepo;

@Service
public class JobSearchService {
	
	@Autowired
	private JobPostRepo jobPostRepo;
	
	@Autowired
	private ModelMapper modelmapper;

	public JobPostDto JobPostToJobPostDto(JobPost jobPost) {
		JobPostDto jobPostDto =modelmapper.map(jobPost, JobPostDto.class);
		return jobPostDto;
	}
	
	public JobPost jobPostDtoTojobPost(JobPostDto jobPostDto) {
		JobPost jobPost =modelmapper.map(jobPostDto, JobPost.class);
		return jobPost;
	}
	
	public List<JobPostDto> jobListByType(String jobType) {
		List<JobPost> jobList = jobPostRepo.findByJobType(jobType);
		List<JobPostDto> getAllPost= jobList.stream().map(jobPost->JobPostToJobPostDto(jobPost)).collect(Collectors.toList());
		return getAllPost;
	}

	public List<JobPostDto> jobListByCity(String jobCity) {
		List<JobPost> jobList = jobPostRepo.findByLocation(jobCity);
		List<JobPostDto> getAllJob= jobList.stream().map(jobPost->JobPostToJobPostDto(jobPost)).collect(Collectors.toList());
		return getAllJob;
	}

	public List<JobPostDto> jobListByJobTitle(String jobTitle) {
		List<JobPost> jobList = jobPostRepo.findByJobTitle(jobTitle);
		List<JobPostDto> getAllJob= jobList.stream().map(jobPost->JobPostToJobPostDto(jobPost)).collect(Collectors.toList());
		return getAllJob;
	}

	public List<JobPostDto> jobListByCompanyName(String companyName) {
		List<JobPost> jobList = jobPostRepo.findByCompanyName(companyName);
		List<JobPostDto> getAllJob= jobList.stream().map(jobPost->JobPostToJobPostDto(jobPost)).collect(Collectors.toList());
		return getAllJob;
	}

	public List<JobPostDto> jobListByTechnology(String technology) {
		List<JobPost> jobList = jobPostRepo.findByTechnology(technology);
		List<JobPostDto> getAllJob= jobList.stream().map(jobPost->JobPostToJobPostDto(jobPost)).collect(Collectors.toList());
		return getAllJob;
	}

	public List<JobPostDto> jobListByWorkExperience(String workExperience) {
		List<JobPost> jobList = jobPostRepo.findByWorkExperience(workExperience);
		List<JobPostDto> getAllJob= jobList.stream().map(jobPost->JobPostToJobPostDto(jobPost)).collect(Collectors.toList());
		return getAllJob;
	}

	public List<JobPostDto> jobListBySalary(String salary) {
		List<JobPost> jobList = jobPostRepo.findBySalary(salary);
		List<JobPostDto> getAllJob= jobList.stream().map(jobPost->JobPostToJobPostDto(jobPost)).collect(Collectors.toList());
		return getAllJob;
	}

}
