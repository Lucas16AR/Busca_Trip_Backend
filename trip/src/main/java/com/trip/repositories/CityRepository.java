package com.trip.repositories;

import com.trip.models.CityModel;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<CityModel, Long> {
}