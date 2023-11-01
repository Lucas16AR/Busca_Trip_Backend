package com.trip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.trip.models.PassengerModel;
import com.trip.repositories.PassengerRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private PassengerRepository passengerRepository;

    @GetMapping
    public ResponseEntity<List<PassengerModel>> getAllPassengers() {
        List<PassengerModel> passengers = (List<PassengerModel>) passengerRepository.findAll();
        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PassengerModel> addPassenger(@Valid @RequestBody PassengerModel passenger) {
        PassengerModel savedPassenger = passengerRepository.save(passenger);
        return new ResponseEntity<>(savedPassenger, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PassengerModel> updatePassenger(@Valid @RequestBody PassengerModel passenger) {
        PassengerModel updatedPassenger = passengerRepository.save(passenger);
        return new ResponseEntity<>(updatedPassenger, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable("id") Long id) {
        passengerRepository.deleteById(id);
        return ResponseEntity.ok("Passenger deleted successfully");
    }
}