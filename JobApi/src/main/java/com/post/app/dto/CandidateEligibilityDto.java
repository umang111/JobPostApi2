package com.post.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateEligibilityDto {

	private String skills;
	private String workExperience;
	private String qualification;
}
