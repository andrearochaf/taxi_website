package ksftaxispringback.repository;

import ksftaxispringback.entity.TaxiRide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationTaxiRideDao extends JpaRepository<TaxiRide, Long> {
}
