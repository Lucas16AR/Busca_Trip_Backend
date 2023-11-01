package com.trip.repositories;

import com.trip.models.CompanyModel;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<CompanyModel, Long> {
}