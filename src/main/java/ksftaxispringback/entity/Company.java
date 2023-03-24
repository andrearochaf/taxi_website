package ksftaxispringback.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Address address;
    private LocalDate disableDate;
    @ManyToMany(mappedBy = "companies")
    private List<Client> clients = new ArrayList<>();

}
