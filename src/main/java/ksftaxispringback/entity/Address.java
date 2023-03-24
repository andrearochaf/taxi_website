package ksftaxispringback.entity;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int streetNumber;
    private String street;
    private int postCode;
    private String city;
    private Long latitude;
    private Long longitude;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private AddressCategory addressCategory;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;


    public Address() {
    }

    public Address(int streetNumber, String street, int postCode, String city, Long latitude, Long longitude, AddressType addressType) {
        this.streetNumber = streetNumber;
        this.street = street;
        this.postCode = postCode;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.addressType = addressType;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getStreetNumber() {
        return streetNumber;
    }
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public int getPostCode() {
        return postCode;
    }
    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Long getLatitude() {
        return latitude;
    }
    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }
    public Long getLongitude() {
        return longitude;
    }
    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }
    public AddressCategory getAddressCategory() {
        return addressCategory;
    }
    public void setAddressCategory(AddressCategory addressCategory) {
        this.addressCategory = addressCategory;
    }
    public AddressType getAddressType() {
        return addressType;
    }
    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }
}
