package com.post.app.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class CandidateEligibility {
	
	@AttributeOverrides({
		@AttributeOverride(
				name="skills",
				column=@Column(name="skills")),
		@AttributeOverride(
				name="workExperience",
				column=@Column(name="work_experience")),
		@AttributeOverride(
				name="qualification",
				column=@Column(name="qualification"))
	})

	@Column(name="skills")
	private String skills;

	@Column(name="work_experience")
	private String workExperience;

	@Column(name="qualification")
	private String qualification;
	
}
