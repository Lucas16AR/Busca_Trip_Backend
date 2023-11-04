package com.trip.services;

import com.trip.repositories.PassengerRepository;
import com.trip.models.PassengerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public PassengerModel addPassenger(PassengerModel passenger) {
        return passengerRepository.save(passenger);
    }

    public PassengerModel updatePassenger(PassengerModel passenger) {
        return passengerRepository.save(passenger);
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }

    public PassengerModel getPassenger(Long id) {
        return passengerRepository.findById(id).orElse(null);
    }

    public List<PassengerModel> getAllPassengers() {
        return (List<PassengerModel>) passengerRepository.findAll();
    }
}