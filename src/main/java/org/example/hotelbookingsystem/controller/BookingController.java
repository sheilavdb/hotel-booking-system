package org.example.hotelbookingsystem.controller;

import jakarta.validation.Valid;
import org.example.hotelbookingsystem.model.Booking;
import org.example.hotelbookingsystem.model.Room;
import org.example.hotelbookingsystem.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlling APIs
@RestController
@RequestMapping("/api")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    //Inte repository för att vi ska inte hoppa över service delen (kontrollen) till repository. Så vi hoppar till service och därifrån till repository.

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping("/bookings")
    public Booking createBooking(@RequestBody @Valid Booking booking) {
        return bookingService.createBooking(booking);
    }

    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok("bokning " + id + " har raderats");
    }

    // Vid större projekt seperat RoomController

    @GetMapping("/rooms")
    public List<Room> getAvailableRooms() {
        return bookingService.getAvailableRooms();
    }
}
