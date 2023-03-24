package ksftaxispringback.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate invoiceDate;
    @OneToOne
    @JoinColumn(name = "taxi_ride_id")
    private TaxiRide taxiRide;
}
