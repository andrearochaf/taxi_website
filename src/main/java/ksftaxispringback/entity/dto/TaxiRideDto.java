package ksftaxispringback.entity.dto;

import ksftaxispringback.entity.Address;

import java.time.LocalDate;
import java.time.LocalTime;

public class TaxiRideDto {

    private LocalDate rideDate;
    private LocalTime rideTime;
    private LocalDate reservationRequestDate;
    private long departureAddressId;
    private long arrivalAddressId;
    private long clientId;

    public LocalDate getRideDate() {
        return rideDate;
    }
    public void setRideDate(LocalDate rideDate) {
        this.rideDate = rideDate;
    }
    public LocalTime getRideTime() {
        return rideTime;
    }
    public void setRideTime(LocalTime rideTime) {
        this.rideTime = rideTime;
    }
    public LocalDate getReservationRequestDate() {
        return reservationRequestDate;
    }
    public void setReservationRequestDate(LocalDate reservationRequestDate) {
        this.reservationRequestDate = reservationRequestDate;
    }
    public long getDepartureAddressId() {
        return departureAddressId;
    }
    public long getArrivalAddressId() {
        return arrivalAddressId;
    }
    public long getClientId() {
        return clientId;
    }
}
