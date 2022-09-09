package com.post.app.dto;

import com.post.app.entity.PercentageCriteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {

	private int companyId;
	private String companyName;
	private String aboutCompany;
	
	private PercentageCriteria percentageCriteria;
	
//	private JobPost jobPost;
}
