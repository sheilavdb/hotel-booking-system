package org.example.hotelbookingsystem.repository;

import org.example.hotelbookingsystem.model.Booking;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepository {
    private List<Booking> bookingArrayList = new ArrayList<>();
    private Long idCreate = 1L;

    public List<Booking> findAll() {
            return bookingArrayList;
        }

    public Booking save(Booking booking) {
        booking.setId(idCreate);
        idCreate++;
        bookingArrayList.add(booking);
        return booking;
    }

    public void deleteById (Long id) {
        Booking bookingToDelete = null;
// chose a for loop istället för lambda function
        for (Booking booking : bookingArrayList) {
            if (booking.getId().equals(id)) {
                bookingToDelete = booking;
            }
        }
        bookingArrayList.remove(bookingToDelete);
    }

    public int countByRoomType(String roomType) {
        int count = 0;
        for( Booking booking : bookingArrayList) {
            if (booking.getRoomType().equals(roomType)) {
                count++;
            }
        }
        return count;
    }
}

