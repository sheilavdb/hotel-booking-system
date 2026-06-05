package org.example.hotelbookingsystem.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RoomFullyBookedException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleRoomFullyBooked(RoomFullyBookedException ex) {
        ErrorMessage error = new ErrorMessage(
                LocalDateTime.now().toString(),
                400,
                ex.getMessage()
        );
        return ResponseEntity.status(400).body(error);
    }

    @ExceptionHandler (GuestCapacityException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleGuestCapacity(GuestCapacityException ex) {
        ErrorMessage error = new ErrorMessage(
                LocalDateTime.now().toString(),
                400,
                ex.getMessage()
        );
        return ResponseEntity.status(400).body(error);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleInternalError(Exception ex) {
        ErrorMessage error = new ErrorMessage(
                LocalDateTime.now().toString(),
                500,
                "Internt fel"
        );
        System.out.println(ex.getMessage());
        return ResponseEntity.status(500).body(error);
    }
}