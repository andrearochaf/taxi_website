package ksftaxispringback.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class AddressCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "addressCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;

    public AddressCategory() {
    }

    public AddressCategory(Long id) {
        this.id = id;
    }

    public AddressCategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
