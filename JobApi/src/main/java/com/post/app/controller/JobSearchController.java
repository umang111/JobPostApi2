package com.post.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.post.app.dto.JobPostDto;
import com.post.app.service.JobSearchService;

@RestController
@RequestMapping("/search")
public class JobSearchController {
	
	@Autowired
	private JobSearchService jobSearchService;
	
	//Job by Job type
	@GetMapping("/jobByType/{jobType}")
	public List<JobPostDto> getJobByJobType(@PathVariable("jobType") String jobType) {
		List<JobPostDto> listOfJobs =jobSearchService.jobListByType(jobType);
		return listOfJobs;
	}
	
	//Job by city
	@GetMapping("/jobByCity/{City}")
	public List<JobPostDto> getJobByCity(@PathVariable("City") String jobCity) {
		List<JobPostDto> listOfJobs =jobSearchService.jobListByCity(jobCity);
		return listOfJobs;
	}
	//Job by title
	
	@GetMapping("/jobByjobTitle/{jobTitle}")
	public List<JobPostDto> getJobByJobTitle(@PathVariable("jobTitle") String jobTitle) {
		List<JobPostDto> listOfJobs =jobSearchService.jobListByJobTitle(jobTitle);
		return listOfJobs;
	}
	
	//Job by company name
	@GetMapping("/jobByCompanyName/{companyName}")
	public List<JobPostDto> getJobByCompanyName(@PathVariable("companyName") String companyName) {
		List<JobPostDto> listOfJobs =jobSearchService.jobListByCompanyName(companyName);
		return listOfJobs;
	}
	
	//Job by technology
	@GetMapping("/jobByTechnology/{technology}")
	public List<JobPostDto> getJobByTechnology(@PathVariable("technology") String technology) {
		List<JobPostDto> listOfJobs =jobSearchService.jobListByTechnology(technology);
		return listOfJobs;
	}
	
	//job by workExperience 
	@GetMapping("/jobByWorkExperience/{workExperience}")
	public List<JobPostDto> getJobByWorkExperience(@PathVariable("workExperience") String workExperience) {
		List<JobPostDto> listOfJobs =jobSearchService.jobListByWorkExperience(workExperience);
		return listOfJobs;
	}
	
	//job by salary Salary
	@GetMapping("/jobBySalary/{salary}")
	public List<JobPostDto> getJobBySalary(@PathVariable("salary") String salary) {
		List<JobPostDto> listOfJobs =jobSearchService.jobListBySalary(salary);
		return listOfJobs;
	}
}





