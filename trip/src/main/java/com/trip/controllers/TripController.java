package com.trip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.trip.models.TripModel;
import com.trip.repositories.TripRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripRepository tripRepository;

    @GetMapping
    public ResponseEntity<List<TripModel>> getAllTrips() {
        List<TripModel> trips = (List<TripModel>) tripRepository.findAll();
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TripModel> addTrip(@Valid @RequestBody TripModel trip) {
        TripModel savedTrip = tripRepository.save(trip);
        return new ResponseEntity<>(savedTrip, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TripModel> updateTrip(@Valid @RequestBody TripModel trip) {
        TripModel updatedTrip = tripRepository.save(trip);
        return new ResponseEntity<>(updatedTrip, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrip(@PathVariable("id") Long id) {
        tripRepository.deleteById(id);
        return ResponseEntity.ok("Trip deleted successfully");
    }
}