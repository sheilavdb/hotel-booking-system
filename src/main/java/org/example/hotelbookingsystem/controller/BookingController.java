package org.example.hotelbookingsystem.controller;

import jakarta.validation.Valid;
import org.example.hotelbookingsystem.model.Booking;
import org.example.hotelbookingsystem.model.Room;
import org.example.hotelbookingsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/rooms")
    public List<Room> getAvailableRooms() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Enkelrum", 10 - bookingService.countByRoomType("Enkelrum")));
        rooms.add(new Room("Dubbelrum", 7 - bookingService.countByRoomType("Dubbelrum")));
        rooms.add(new Room("Svit", 3 - bookingService.countByRoomType("Svit")));
        return rooms;
    }
}
