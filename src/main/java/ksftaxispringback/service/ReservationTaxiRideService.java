package ksftaxispringback.service;

import ksftaxispringback.entity.TaxiRide;
import ksftaxispringback.entity.dto.TaxiRideDto;

public interface ReservationTaxiRideService {

    TaxiRide save(TaxiRideDto taxiRideDto);
}
