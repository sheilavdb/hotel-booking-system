package org.example.hotelbookingsystem.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Booking {
    private Long id;
    @NotBlank(message = "Namn får inte vara tom")
    private String guestName;
    @Pattern(regexp = "Enkelrum|Dubbelrum|Svit", message = "Välj mellan: Enkelrum, Dubbelrum, Svit")
    @NotBlank(message = "rumstyp får inte vara tom")
    private String roomType;

    @Min(value = 1, message = "Antal gäster ska vara minst 1")
    @Max(value = 3, message = "Antal gäster ska inte överstiga 3")
    private int numberOfGuests;
// Behövs ingen validering, automatisk beräkning
    private Double totalPrice;

    public Booking() {
    }

    public Booking(Long id, String guestName, String roomType, int numberOfGuests, Double totalPrice) {
        this.id = id;
        this.guestName = guestName;
        this.roomType = roomType;
        this.numberOfGuests = numberOfGuests;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
