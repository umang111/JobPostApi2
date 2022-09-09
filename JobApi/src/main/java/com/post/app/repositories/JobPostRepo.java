package com.post.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.post.app.entity.JobPost;

public interface JobPostRepo extends JpaRepository<JobPost,Integer>  {

	List<JobPost> findByJobType(String jobType);

	List<JobPost> findByLocation(String jobCity);

	List<JobPost> findByJobTitle(String jobTitle);

	@Query("select j from JobPost j where company.companyName = ?1")
	List<JobPost> findByCompanyName(String companyName);

	@Query("select j from JobPost j where candidateEligibility.skills = ?1")
	List<JobPost> findByTechnology(String technology);

	@Query("select j from JobPost j where candidateEligibility.workExperience = ?1")
	List<JobPost> findByWorkExperience(String workExperience);

	List<JobPost> findBySalary(String salary);
	
}
