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

import com.post.app.dto.CompanyDto;
import com.post.app.exceptions.RefundRequestStatusNotAvailable;
import com.post.app.service.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/addCompany")
	public ResponseEntity<CompanyDto> addCompany(@RequestBody CompanyDto companyDto) throws RefundRequestStatusNotAvailable {
		CompanyDto addedCompany = companyService.addCompany(companyDto);
		return new ResponseEntity<CompanyDto>(addedCompany,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCompany/{companyid}")
	public ResponseEntity<CompanyDto> updateCompany(@PathVariable("companyid") Integer companyId,@RequestBody CompanyDto companyDto) {
		CompanyDto addedCompany = companyService.UpdateCompany(companyId,companyDto);
		return new ResponseEntity<CompanyDto>(addedCompany,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteCompany/{companyId}")
	public void deleteCompany(@PathVariable Integer companyId) {
		 companyService.deleteCompany(companyId);
	}
	
	@GetMapping("/findById/{companyId}")
	public CompanyDto findById(@PathVariable Integer companyId) {
		CompanyDto getCompany= companyService.findCompanyById(companyId);
		return getCompany;
	}
	
	@GetMapping("/findAllCompany")
	public List<CompanyDto> findAllCompany(){
		List<CompanyDto> ListOfCompany= companyService.findAllCompany();
		return ListOfCompany;
	}
}








