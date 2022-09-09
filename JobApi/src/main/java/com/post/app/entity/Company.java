package com.post.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="company")
public class Company {
	
	@Id
	@GeneratedValue
	@Column(name="company_id")
	private int companyId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="about_company")
	private String aboutCompany;
	
	@Embedded
	private PercentageCriteria percentageCriteria;

	@OneToMany(mappedBy="company",cascade=CascadeType.ALL)
	private List<JobPost> jobPost;
}
