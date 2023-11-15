package com.trip.repositories;
import com.trip.models.CompanyModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {
}