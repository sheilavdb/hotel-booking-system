package org.example.hotelbookingsystem.exception;

public class ErrorMessage {
    private String timestamp;
    private int status;
    private String message;

    public ErrorMessage(String timestamp, int status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
