package com.trip.repositories;

import com.trip.models.BookingModel;
import org.springframework.data.repository.CrudRepository;
 
public interface BookingRepository extends CrudRepository<BookingModel, Long> {
}