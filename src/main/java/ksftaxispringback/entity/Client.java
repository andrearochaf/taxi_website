package ksftaxispringback.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client extends Person{

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "client_company")
    private List<Company> companies;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TaxiRide> taxiRideList = new ArrayList<>();

    public Client() {
    }

    public Client(Long id) {
        super(id);
    }

}
