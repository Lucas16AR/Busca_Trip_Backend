package com.trip.controllers;

import com.trip.models.BookingModel;
import com.trip.services.BookingService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



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
        bookingService.deleteBooking(id);
        return new ResponseEntity<>("Booking deleted successfully", HttpStatus.OK);
    }
}