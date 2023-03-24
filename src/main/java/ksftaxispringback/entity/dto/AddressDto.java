package ksftaxispringback.entity.dto;

import ksftaxispringback.entity.AddressType;

public class AddressDto {

    private int streetNumber;
    private String street;
    private int postCode;
    private String city;
    private Long latitude;
    private Long longitude;
    private AddressType addressType;

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
    public AddressType getAddressType() {
        return addressType;
    }
    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }
}
