package com.jesus.coupons.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.coupons.entities.Company;
import com.jesus.coupons.exceptions.ApplicationException;
import com.jesus.coupons.logic.CompaniesController;


@RestController
@RequestMapping("/companies")
public class CompaniesApi {


	@Autowired
	private CompaniesController companiesController;

	
	@PostMapping
	public void createCompany(@RequestBody Company company) throws ApplicationException {
		this.companiesController.createCompany(company);
	}

	
	@PutMapping
	public void updateCompany(@RequestBody Company company) throws ApplicationException {
		this.companiesController.updateCompany(company);
	}

	
	@GetMapping("{companyId}")
	public Company getCompany(@PathVariable("companyId") long companyId) throws ApplicationException {
		return this.companiesController.getCompany(companyId);
	}


	@GetMapping()
	public List<Company> getAllCompanys() throws ApplicationException {
		return this.companiesController.getAllCompanies();
	}


	@DeleteMapping("{companyId}")
	public void deleteCompany(@PathVariable("companyId") long companyId) throws ApplicationException {
		this.companiesController.deleteCompany(companyId);
	}


}