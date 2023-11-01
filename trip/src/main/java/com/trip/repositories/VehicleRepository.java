package com.trip.repositories;

import com.trip.models.VehicleModel;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<VehicleModel, Long> {
}