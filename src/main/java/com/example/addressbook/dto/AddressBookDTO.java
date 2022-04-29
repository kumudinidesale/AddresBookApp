package com.example.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.Pattern;

import javax.validation.constraints.NotEmpty;
@Data
@AllArgsConstructor
public class AddressBookDTO {

    @Pattern(regexp="^[A-Z]{1}[a-zA-Z]{2,}$",message="Employee firstName is Invalid")
    private String firstName;
    @Pattern(regexp="^[A-Z]{1}[a-zA-Z]{2,}$",message="Employee lastName is Invalid")
    private String lastName;
    @NotEmpty(message="address not  null")
    private String address;
    @NotEmpty(message="phoneNumber not  null")
    private String phoneNumber;
    @NotEmpty(message="city not  null")
    private String city;
    @NotEmpty(message="state not  null")
    private String state;
    @NotEmpty(message="zip not  null")
    private Integer zip;
    public AddressBookDTO() {
        super();
    }

//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String email) {
//        this.address = email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public Integer getZip() {
//        return zip;
//    }
//
//    public void setZip(Integer zip) {
//        this.zip = zip;
//    }
}
