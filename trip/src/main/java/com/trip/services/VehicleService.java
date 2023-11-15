package com.trip.services;

import com.trip.repositories.VehicleRepository;
import com.trip.models.VehicleModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleModel addVehicle(VehicleModel vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public VehicleModel updateVehicle(VehicleModel vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    public Optional<VehicleModel> getVehicle(Long id) {
        return vehicleRepository.findById(id);
    }

    public List<VehicleModel> getAllVehicles() {
        return vehicleRepository.findAll();
    }
}
