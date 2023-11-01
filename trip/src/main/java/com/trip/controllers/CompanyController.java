package com.trip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.trip.models.CompanyModel;
import com.trip.repositories.CompanyRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public ResponseEntity<List<CompanyModel>> getAllCompanies() {
        List<CompanyModel> companies = (List<CompanyModel>) companyRepository.findAll();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CompanyModel> addCompany(@Valid @RequestBody CompanyModel company) {
        CompanyModel savedCompany = companyRepository.save(company);
        return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CompanyModel> updateCompany(@Valid @RequestBody CompanyModel company) {
        CompanyModel updatedCompany = companyRepository.save(company);
        return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable("id") Long id) {
        companyRepository.deleteById(id);
        return ResponseEntity.ok("Company deleted successfully");
    }
}