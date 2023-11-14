package com.trip.controllers;

import com.trip.models.CompanyModel;
import com.trip.services.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<CompanyModel>> getAllCompanies() {
        List<CompanyModel> companies = companyService.getAllCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CompanyModel> addCompany(@Valid @RequestBody CompanyModel company) {
       CompanyModel savedCompany = companyService.addCompany(company);
       return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
   }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyModel> updateCompany(@PathVariable("id") Long id, @Valid @RequestBody CompanyModel company) {
        CompanyModel existingCompany = companyService.getCompany(id);

        if (existingCompany != null) {
            company.setId(id);
            CompanyModel updatedCompany = companyService.updateCompany(company);
            return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable("id") Long id) {
        CompanyModel existingCompany = companyService.getCompany(id);

        if (existingCompany != null) {
            companyService.deleteCompany(id);
            return ResponseEntity.ok("Company deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
