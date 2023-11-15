package com.trip.controllers;

import com.trip.models.TripModel;
import com.trip.services.TripService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    private TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public List<TripModel> getAllTrips() {
        return tripService.getAllTrips();
    }

    @PostMapping
    public ResponseEntity<String> addTrip(@RequestBody TripModel trip) {
        TripModel savedTrip = tripService.addTrip(trip);
        if (savedTrip != null) {
            return ResponseEntity.status(201).body("Trip added successfully with ID: " + savedTrip.getId());
        } else {
            return ResponseEntity.status(400).body("Failed to add trip.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTrip(@PathVariable("id") Long id, @RequestBody TripModel trip) {
        TripModel updatedTrip = tripService.updateTrip(id, trip);
        if (updatedTrip != null) {
            return ResponseEntity.ok("Trip updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrip(@PathVariable("id") Long id) {
        TripModel existingTrip = tripService.getTrip(id);
        if (existingTrip != null) {
            tripService.deleteTrip(id);
            return ResponseEntity.ok("Trip deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


