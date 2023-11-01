package com.trip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.trip.models.VehicleModel;
import com.trip.repositories.VehicleRepository;

@RestController
@RequestMapping(VehicleController.VEHICLE_URL)
public class VehicleController {
   
    private static final String VEHICLE_URL = "/vehicle";
   
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping
    public List<VehicleModel> getAllVehicles() {
        return (List<VehicleModel>) vehicleRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> addVehicle(@RequestBody VehicleModel vehicle) {
        vehicleRepository.save(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body("Vehicle added successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateVehicle(@RequestBody VehicleModel vehicle) {
        vehicleRepository.save(vehicle);
        return ResponseEntity.ok("Vehicle updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") Long id) {
        Optional<VehicleModel> vehicleOptional = vehicleRepository.findById(id);
        if (vehicleOptional.isPresent()) {
            vehicleRepository.deleteById(id);
            return ResponseEntity.ok("Vehicle deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}