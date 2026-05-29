package org.example.hotelbookingsystem.service;

import org.example.hotelbookingsystem.exception.GuestCapacityException;
import org.example.hotelbookingsystem.exception.RoomFullyBookedException;
import org.example.hotelbookingsystem.model.Booking;
import org.example.hotelbookingsystem.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        if(booking.getRoomType().equals("Enkelrum") && bookingRepository.countByRoomType(booking.getRoomType()) >= 10) {
            throw new RoomFullyBookedException("Alla enkelrum är bokade");
        }
        if(booking.getRoomType().equals("Dubbelrum") && bookingRepository.countByRoomType(booking.getRoomType()) >= 7) {
            throw new RoomFullyBookedException("Alla dubbelrum är bokade");
        }
        if(booking.getRoomType().equals("Svit") && bookingRepository.countByRoomType(booking.getRoomType()) >= 3) {
            throw new RoomFullyBookedException("Alla svit är bokade");
        }

        if(booking.getRoomType().equals("Enkelrum") && booking.getNumberOfGuests() > 1 ) {
            throw new GuestCapacityException("Enkelrum kan inte har mer än 1 gäst.");
        }
        if(booking.getRoomType().equals("Dubbelrum") && booking.getNumberOfGuests() > 2 ) {
            throw new GuestCapacityException("Dubbelrum kan inte har mer än 2 gäster.");
        }
        if(booking.getRoomType().equals("Svit") && booking.getNumberOfGuests() > 3 ) {
            throw new GuestCapacityException("Svit kan inte har mer än 3 gäster.");
        }

        if(booking.getRoomType().equals("Enkelrum")) {
            booking.setTotalPrice(500);
        } else if (booking.getRoomType().equals("Dubbelrum")) {
            booking.setTotalPrice(1000);
        } else {
            booking.setTotalPrice(2000);
        }
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    public void deleteBooking(int id) {
        bookingRepository.deleteById(id);
    }

    public int countByRoomType(String roomType) {
        return bookingRepository.countByRoomType(roomType);
    }

}
