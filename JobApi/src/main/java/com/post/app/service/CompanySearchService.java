package com.post.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.app.dto.CompanyListWithOnlyId;
import com.post.app.entity.Company;
import com.post.app.repositories.CompanyRepo;

@Service
public class CompanySearchService {
	
	@Autowired
	private CompanyRepo companyRepo;

	public List<CompanyListWithOnlyId> getListOfAllCompanyWithId() {
		List<Company> GetList=companyRepo.findAll();
		List<CompanyListWithOnlyId> getAllList=GetList.stream().map(jobPost->getDetailsOfCompany(jobPost)).collect(Collectors.toList());
		return getAllList;
	}

	private CompanyListWithOnlyId getDetailsOfCompany(Company jobPost) {
		CompanyListWithOnlyId listOfCompanys= new CompanyListWithOnlyId();
		listOfCompanys.setCompanyName(jobPost.getCompanyName());
		listOfCompanys.setCompanyId(jobPost.getCompanyId());
		return listOfCompanys;
	}

}
