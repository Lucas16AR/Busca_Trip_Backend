package com.trip.services;

import com.trip.repositories.BookingRepository;
import com.trip.models.BookingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
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
        return bookingRepository.findAll();
    }
}