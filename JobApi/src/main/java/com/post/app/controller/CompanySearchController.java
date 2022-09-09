package com.post.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.post.app.dto.CompanyListWithOnlyId;
import com.post.app.service.CompanySearchService;

@RestController
@RequestMapping("/search/company")
public class CompanySearchController {

	@Autowired
	private CompanySearchService CompanySearchService;
	
	@GetMapping("/listOfAllCompany")
	public List<CompanyListWithOnlyId> getListOfAllCompanyWithId(){
		List<CompanyListWithOnlyId> companyListWithOnlyId = CompanySearchService.getListOfAllCompanyWithId();
		return companyListWithOnlyId;
	}
}
