package ksftaxispringback.service.impl;

import ksftaxispringback.entity.Address;
import ksftaxispringback.entity.Client;
import ksftaxispringback.entity.TaxiRide;
import ksftaxispringback.entity.dto.TaxiRideDto;
import ksftaxispringback.repository.*;
import ksftaxispringback.service.ReservationTaxiRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class ReservationTaxiRideServiceImpl implements ReservationTaxiRideService {

    private ReservationTaxiRideDao reservationTaxiRideDao;
    private AddressDao addressDao;


    @Override
    public TaxiRide save(TaxiRideDto taxiRideDto) {

        taxiRideDto.setReservationRequestDate(LocalDate.now());
        Client client = new Client(taxiRideDto.getClientId());
        Address departureAddress = addressDao.findById(taxiRideDto.getDepartureAddressId());
        Address arrivalAddress = addressDao.findById(taxiRideDto.getArrivalAddressId());

        TaxiRide taxiRide= new TaxiRide(taxiRideDto.getRideDate(), taxiRideDto.getRideTime(),taxiRideDto.getReservationRequestDate(),
                departureAddress,arrivalAddress, client);
        return reservationTaxiRideDao.save(taxiRide);
    }

    @Autowired
    public void setReservationTaxiRideDao(ReservationTaxiRideDao reservationTaxiRideDao) {
        this.reservationTaxiRideDao = reservationTaxiRideDao;
    }

    @Autowired
    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
}
