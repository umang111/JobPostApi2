package com.post.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.post.app.entity.Company;

public interface CompanyRepo extends JpaRepository<Company,Integer>{

//	@Query("select c from Company c where companyName=?1")
//	Company findByCompanyName(String companynametosearch);

//	@Query("select c from Company c where companyName=?1")
//	Company findByName(String companynametosearch);

	Optional<Company> findByCompanyName(String companyName);

//	Company findByCompanyName();
}
