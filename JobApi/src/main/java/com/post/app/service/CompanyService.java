package com.post.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.app.dto.CompanyDto;
import com.post.app.entity.Company;
import com.post.app.entity.PercentageCriteria;
import com.post.app.exceptions.RefundRequestStatusNotAvailable;
import com.post.app.repositories.CompanyRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompanyService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CompanyRepo compnayRepo;

	public Company CompanyDtoToCompany(CompanyDto companyDto) {
		Company company =modelMapper.map(companyDto, Company.class);
				return company;
	}
	
	public CompanyDto CompanytoCompanyDto(Company company) {
		CompanyDto companyDto =modelMapper.map(company, CompanyDto.class);
		return companyDto;
	}
	
	public CompanyDto addCompany(CompanyDto companyDto) throws RefundRequestStatusNotAvailable {
		Optional<Company> companyNamesdf = compnayRepo.findByCompanyName(companyDto.getCompanyName());
		if(companyNamesdf.isPresent()) {
			log.info("company Already Exist"+companyNamesdf);
			throw new RefundRequestStatusNotAvailable("refundId already exists");
		}
		
		Company company =CompanyDtoToCompany(companyDto);
		Company addedCompany= compnayRepo.save(company);
		return CompanytoCompanyDto(addedCompany);
	}

	public CompanyDto UpdateCompany(int companyId, CompanyDto companyDto) {
		Company updatedCompany=compnayRepo.findById(companyId).get();
		
		updatedCompany.setCompanyName(companyDto.getCompanyName());
		
		updatedCompany.setAboutCompany(companyDto.getCompanyName());
		PercentageCriteria percentageCriteria = new PercentageCriteria();
		percentageCriteria.setGraduationPercentage(companyDto.getPercentageCriteria().getGraduationPercentage());
		percentageCriteria.setTenClassPercentage(updatedCompany.getPercentageCriteria().getTenClassPercentage());
		percentageCriteria.setTwelveClassPercentage(updatedCompany.getPercentageCriteria().getTwelveClassPercentage());
		updatedCompany.setPercentageCriteria(percentageCriteria);
		
		Company CompanyIsUpdated= compnayRepo.save(updatedCompany);
 		return  CompanytoCompanyDto(CompanyIsUpdated);
 		
	}

	public void deleteCompany(Integer companyId) {
		 compnayRepo.deleteById(companyId);
	}

	public CompanyDto findCompanyById(Integer companyId) {
		Company updatedCompany=compnayRepo.findById(companyId).get();
		return CompanytoCompanyDto(updatedCompany);
	}

	public List<CompanyDto> findAllCompany() {
		List<Company> AllCompany=compnayRepo.findAll();
		List<CompanyDto> ListOfCompany=AllCompany.stream().map(company->CompanytoCompanyDto(company)).collect(Collectors.toList());
		return ListOfCompany;
	}
	
}












