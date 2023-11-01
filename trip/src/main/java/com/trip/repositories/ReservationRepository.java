package com.trip.repositories;

import com.trip.models.ReservationModel;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<ReservationModel, Long> {
}