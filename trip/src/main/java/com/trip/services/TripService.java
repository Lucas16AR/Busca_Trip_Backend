package com.trip.services;

import com.trip.repositories.TripRepository;
import com.trip.models.TripModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public TripModel addTrip(TripModel trip) {
        return tripRepository.save(trip);
    }

    public TripModel updateTrip(TripModel trip) {
        return tripRepository.save(trip);
    }

    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    public TripModel getTrip(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    public List<TripModel> getAllTrips() {
        return (List<TripModel>) tripRepository.findAll();
    }

}