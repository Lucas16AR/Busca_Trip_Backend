package com.trip.services;

import com.trip.repositories.ReservationRepository;
import com.trip.models.ReservationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ReservationModel addReservation(ReservationModel reservation) {
        return reservationRepository.save(reservation);
    }

    public ReservationModel updateReservation(ReservationModel reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public ReservationModel getReservation(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public List<ReservationModel> getAllReservations() {
        return (List<ReservationModel>) reservationRepository.findAll();
    }

}