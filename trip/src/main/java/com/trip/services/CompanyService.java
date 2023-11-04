package com.trip.services;

import com.trip.repositories.CompanyRepository;
import com.trip.models.CompanyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompanyService {
 
    @Autowired
    private CompanyRepository companyRepository;
   
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyModel addCompany(CompanyModel company) {
        return companyRepository.save(company);
    }

    public CompanyModel updateCompany(CompanyModel company) {
        return companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    public CompanyModel getCompany(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public List<CompanyModel> getAllCompanies() {
        return (List<CompanyModel>) companyRepository.findAll();
    }
}