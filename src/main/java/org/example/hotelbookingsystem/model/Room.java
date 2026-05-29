package org.example.hotelbookingsystem.model;

public class Room {
    private String roomType;

    private int availableRooms;

    public Room() {
    }

    public Room(String roomType, int availableRooms) {
        this.roomType = roomType;
        this.availableRooms = availableRooms;
    }

    public String getType() {
        return roomType;
    }

    public int getCountByRoomType() {
        return availableRooms;
    }
}
