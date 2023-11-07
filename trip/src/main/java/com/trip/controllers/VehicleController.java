package com.trip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.trip.models.CityModel;
import com.trip.models.VehicleModel;
import com.trip.repositories.VehicleRepository;
import com.trip.repositories.CityRepository;  // Agrega la importación del repositorio de ciudades


import jakarta.validation.Valid;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
   
    private VehicleRepository vehicleRepository;
    private final CityRepository cityRepository; 

    @Autowired
    public VehicleController(VehicleRepository vehicleRepository, CityRepository cityRepository) {
        this.vehicleRepository = vehicleRepository;
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public List<VehicleModel> getAllVehicles() {
        return (List<VehicleModel>) vehicleRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<VehicleModel> addVehicle(@Valid @RequestBody VehicleModel vehicle) {
        if (vehicle.getOrigin_city() != null) {
            // Recuperar la ciudad de origen por ID
            CityModel originCity = cityRepository.findById(vehicle.getOrigin_city().getId()).orElse(null);
            if (originCity != null) {
                vehicle.setOrigin_city(originCity);
            }
        }

        if (vehicle.getDestination_city() != null) {
            // Recuperar la ciudad de destino por ID
            CityModel destinationCity = cityRepository.findById(vehicle.getDestination_city().getId()).orElse(null);
            if (destinationCity != null) {
                vehicle.setDestination_city(destinationCity);
            }
        }

        VehicleModel savedVehicle = vehicleRepository.save(vehicle);
        return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
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