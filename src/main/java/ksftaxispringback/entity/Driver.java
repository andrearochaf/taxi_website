package ksftaxispringback.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver extends Person{

    private Long taxiLicenceNumber;
    private Long driverLicenceNumber;
    private Long medicalLicenceNumber;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Unavailability> unavailabilities = new ArrayList<>();
}
