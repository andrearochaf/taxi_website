package ksftaxispringback.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Unavailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate beginUnavailableDate;
    private LocalDate endUnavailableDate;
    private LocalDate disableDate;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Driver driver;
}
