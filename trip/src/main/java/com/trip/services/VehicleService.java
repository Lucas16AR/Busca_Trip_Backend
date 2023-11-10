package com.trip.services;

import com.trip.repositories.VehicleRepository;
import com.trip.models.VehicleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

    public VehicleModel getVehicle(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public List<VehicleModel> getAllVehicles() {
        return (List<VehicleModel>) vehicleRepository.findAll();
    }

}