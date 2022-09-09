package com.post.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.post.app.dto.JobPostDto;
import com.post.app.dto.UpdatePost;
import com.post.app.response.ApiResponse;
import com.post.app.service.JobPostService;

@RestController
public class JobPostController {

	@Autowired
	private JobPostService jobPostService;
	
	@PostMapping("/postJobWithNewCompany")
	public ResponseEntity<JobPostDto> postJob(@RequestBody JobPostDto jobPostDto) {
		JobPostDto posted= jobPostService.postJob(jobPostDto);
		return new ResponseEntity<JobPostDto>(posted,HttpStatus.CREATED);
	}
	
	@PostMapping("/postJobWithCompanyId/{companyId}")
	public ResponseEntity<JobPostDto> postJobWithCompanyId(
			@PathVariable("companyId") Integer companyId,@RequestBody JobPostDto jobPostDto ){
		JobPostDto posted= jobPostService.postJobWithCompanyId(companyId,jobPostDto);
		return new ResponseEntity<JobPostDto>(posted,HttpStatus.CREATED);
	}
	
	@PutMapping("/updatePost/{postId}")
	public ResponseEntity<JobPostDto> updatePost(@PathVariable Integer postId,@RequestBody UpdatePost updatePost){
		JobPostDto updatedPost =jobPostService.updatePost(postId,updatePost);
		return new ResponseEntity<JobPostDto>(updatedPost,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteJobByid/{jobPostId}")
	public ResponseEntity<ApiResponse> deleteJobPost(@PathVariable Integer jobPostId) {
		jobPostService.deleteJobPost(jobPostId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post Deleted successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/findJobPostById/{jobPostId}")
	public ResponseEntity<JobPostDto> getJobPostById(@PathVariable Integer jobPostId){
		JobPostDto getJobPost =jobPostService.getJobPostById(jobPostId);
		return new ResponseEntity<>(getJobPost,HttpStatus.OK);
	}
	
	@GetMapping("/findListOfPost")
	public List<JobPostDto> findAllPost(){
		 List<JobPostDto> listOfjobPost =jobPostService.findAllJobPost();
		 return listOfjobPost;
	}
}













