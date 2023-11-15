package com.trip.repositories;
import com.trip.models.CityModel;
import com.trip.models.TripModel;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface TripRepository extends JpaRepository<TripModel, Long> {
    @Query("SELECT t FROM TripModel t WHERE t.origin_city = :origin AND t.destination_city = :destination AND t.date >= :departureTimeStart AND t.date < :departureTimeEnd")
    List<TripModel> findByOriginAndDestination(@Param("origin") CityModel origin, @Param("destination") CityModel destination, @Param("departureTimeStart") Timestamp departureTimeStart, @Param("departureTimeEnd") Timestamp departureTimeEnd);
}
