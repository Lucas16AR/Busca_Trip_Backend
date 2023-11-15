package com.trip.repositories;
import com.trip.models.TripModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface TripRepository extends JpaRepository<TripModel, Long> {
}