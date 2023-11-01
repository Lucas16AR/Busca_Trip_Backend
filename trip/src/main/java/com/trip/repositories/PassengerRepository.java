package com.trip.repositories;

import com.trip.models.PassengerModel;
import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<PassengerModel, Long> {
}