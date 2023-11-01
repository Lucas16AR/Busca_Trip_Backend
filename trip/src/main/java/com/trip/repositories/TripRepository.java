package com.trip.repositories;

import com.trip.models.TripModel;
import org.springframework.data.repository.CrudRepository;

public interface TripRepository extends CrudRepository<TripModel, Long> {
}