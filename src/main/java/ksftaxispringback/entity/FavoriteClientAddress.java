package ksftaxispringback.entity;


import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class FavoriteClientAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Address address;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Client client;

}
