package com.trip.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.trip.models.BookingModel;
import com.trip.services.BookingService;


@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<BookingModel>> getAllBookings() {
        List<BookingModel> bookings = bookingService.findAll();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookingModel> addBooking(@Valid @RequestBody BookingModel booking) {
        BookingModel savedBooking = bookingService.save(booking);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BookingModel> updateBooking(@Valid @RequestBody BookingModel booking) {
        BookingModel updatedBooking = bookingService.update(booking);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable("id") Long id) {
        bookingService.deleteById(id);
        return new ResponseEntity<>("Booking deleted successfully", HttpStatus.OK);
    }
}