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
public class PercentageCriteria {

	@AttributeOverrides({
		@AttributeOverride(
				name="tenClassPercentage",
				column=@Column(name="10th_percentage ")),
		@AttributeOverride(
				name="twelveClassPercentage",
				column=@Column(name="12th_percentage")),
		@AttributeOverride(
				name="graduationPercentage",
				column=@Column(name="graduation_percentage"))
	})
	
	private String tenClassPercentage;
	private String twelveClassPercentage;
	private String graduationPercentage;
}
