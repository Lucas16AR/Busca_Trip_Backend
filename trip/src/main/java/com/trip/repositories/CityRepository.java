package com.trip.repositories;

import com.trip.models.CityModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<CityModel, Long> {
    // CityModel findById(long id);
    // CityModel updateCity(@Valid CityModel city);
}