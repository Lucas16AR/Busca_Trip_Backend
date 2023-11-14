package com.trip.controllers;

import com.trip.models.VehicleModel;
import com.trip.services.CompanyService;
import com.trip.services.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trip.models.CompanyModel;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private VehicleService vehicleService;
    private CompanyService companyService;

    @Autowired
    public VehicleController(VehicleService vehicleService, CompanyService companyService) {
        this.vehicleService = vehicleService;
        this.companyService = companyService;
    }

    @GetMapping
    public List<VehicleModel> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PostMapping("/{companyId}")
    public ResponseEntity<String> addVehicle(@PathVariable("companyId") Long companyId, @RequestBody VehicleModel vehicle) {
        Optional<CompanyModel> optionalCompany = companyService.findById(companyId);
        if (optionalCompany.isPresent()) {
            CompanyModel company = optionalCompany.get();
            vehicle.setCompany(company);
            VehicleModel savedVehicle = vehicleService.addVehicle(vehicle);
            if (savedVehicle != null) {
                return ResponseEntity.status(201).body("Vehicle added successfully with ID: " + savedVehicle.getId());
            } else {
                return ResponseEntity.status(400).body("Failed to add vehicle.");
            }
        } else {
            return ResponseEntity.status(400).body("Company with ID " + companyId + " does not exist.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateVehicle(@PathVariable("id") Long id, @RequestBody VehicleModel vehicle) {
        Optional<VehicleModel> existingVehicle = vehicleService.getVehicle(id);

        if (existingVehicle.isPresent()) {
            vehicle.setId(id);
            vehicleService.updateVehicle(vehicle);
            return ResponseEntity.ok("Vehicle updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") Long id) {
        Optional<VehicleModel> existingVehicle = vehicleService.getVehicle(id);

        if (existingVehicle.isPresent()) {
            vehicleService.deleteVehicle(id);
            return ResponseEntity.ok("Vehicle deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

