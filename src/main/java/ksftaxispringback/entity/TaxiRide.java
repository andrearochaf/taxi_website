package ksftaxispringback.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TaxiRide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate rideDate;
    private LocalTime rideTime;
    private Float estimate;
    private LocalDate reservationRequestDate;
    private LocalDate validationReservationDate;
    private LocalDate refusedReservationDate;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private PaymentType paymentType;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Address departureAddress;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Address arrivalAddress;

    public TaxiRide() {
    }

    public TaxiRide(LocalDate rideDate, LocalTime rideTime, LocalDate reservationRequestDate, Address departureAddress, Address arrivalAddress, Client client) {
        this.rideDate = rideDate;
        this.rideTime = rideTime;
        this.reservationRequestDate = reservationRequestDate;
        this.departureAddress = departureAddress;
        this.arrivalAddress = arrivalAddress;
        this.client = client;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Address getDepartureAddress() {
        return departureAddress;
    }
    public Address getArrivalAddress() {
        return arrivalAddress;
    }
    public LocalDate getRideDate() {
        return rideDate;
    }
    public LocalTime getRideTime() {
        return rideTime;
    }
    public float getEstimate() {
        return estimate;
    }
    public LocalDate getReservationRequestDate() {
        return reservationRequestDate;
    }
    public LocalDate getValidationReservationDate() {
        return validationReservationDate;
    }
    public LocalDate getRefusedReservationDate() {
        return refusedReservationDate;
    }
    public PaymentType getPaymentType() {
        return paymentType;
    }
    public Client getClient() {
        return client;
    }

    public void setRideDate(LocalDate rideDate) {
        this.rideDate = rideDate;
    }
    public void setRideTime(LocalTime rideTime) {
        this.rideTime = rideTime;
    }
    public void setEstimate(float estimate) {
        this.estimate = estimate;
    }
    public void setReservationRequestDate(LocalDate reservationRequestDate) {
        this.reservationRequestDate = reservationRequestDate;
    }
    public void setValidationReservationDate(LocalDate validationReservationDate) {
        this.validationReservationDate = validationReservationDate;
    }
    public void setRefusedReservationDate(LocalDate refusedReservationDate) {
        this.refusedReservationDate = refusedReservationDate;
    }
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public void setDepartureAddress(Address departureAddress) {
        this.departureAddress = departureAddress;
    }
    public void setArrivalAddress(Address arrivalAddress) {
        this.arrivalAddress = arrivalAddress;
    }
}
