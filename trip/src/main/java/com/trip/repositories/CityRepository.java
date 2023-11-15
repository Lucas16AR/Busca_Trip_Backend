package com.trip.repositories;
import com.trip.models.CityModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CityRepository extends JpaRepository<CityModel, Long> {
}