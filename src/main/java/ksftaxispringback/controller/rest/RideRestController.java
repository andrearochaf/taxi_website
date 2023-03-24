package ksftaxispringback.controller.rest;

import ksftaxispringback.entity.Address;
import ksftaxispringback.entity.TaxiRide;
import ksftaxispringback.entity.dto.AddressDto;
import ksftaxispringback.entity.dto.TaxiRideDto;
import ksftaxispringback.service.AddressService;
import ksftaxispringback.service.ReservationTaxiRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RideRestController {

    private AddressService addressService;
    private ReservationTaxiRideService reservationTaxiRideService;


    @PostMapping("/address")
    public Address saveAddress(@RequestBody AddressDto addressDto) {
        return addressService.save(addressDto);
    }

    @PostMapping("/reservation")
    public TaxiRide save(@RequestBody TaxiRideDto taxiRideDto) {
        return reservationTaxiRideService.save(taxiRideDto);
    }


    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @Autowired
    public void setReservationTaxiRideService(ReservationTaxiRideService reservationTaxiRideService) {
        this.reservationTaxiRideService = reservationTaxiRideService;
    }
}
