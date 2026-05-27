package org.example.hotelbookingsystem.controller;

import jakarta.validation.Valid;
import org.example.hotelbookingsystem.model.Booking;
import org.example.hotelbookingsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {
     @Autowired
        private BookingService bookingService;


    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping("/bookings")
    public Booking createBooking(@RequestBody @Valid Booking booking) {
        return bookingService.createBooking(booking);
    }

    @DeleteMapping("/bookings/{id}")
    public void deleteBooking(@PathVariable int id) {
        bookingService.deleteBooking(id);
    }
}
