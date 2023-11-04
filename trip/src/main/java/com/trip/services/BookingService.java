package com.trip.services;

import com.trip.models.BookingModel;
import com.trip.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.validation.Valid;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public BookingModel addBooking(BookingModel booking) {
        return bookingRepository.save(booking);
    }

    public BookingModel updateBooking(BookingModel booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public BookingModel getBooking(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public List<BookingModel> getAllBookings() {
        return (List<BookingModel>) bookingRepository.findAll();
    }

    public List<BookingModel> findAll() {
        return null;
    }

    public BookingModel update(@Valid BookingModel booking) {
        return null;
    }

    public BookingModel save(@Valid BookingModel booking) {
        return null;
    }
}