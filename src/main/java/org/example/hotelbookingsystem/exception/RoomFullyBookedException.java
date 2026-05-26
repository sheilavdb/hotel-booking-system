package org.example.hotelbookingsystem.exception;

public class RoomFullyBookedException extends RuntimeException {
    public RoomFullyBookedException(String message) {
        super(message);
    }
}
