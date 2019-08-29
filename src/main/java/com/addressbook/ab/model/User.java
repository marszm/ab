package com.addressbook.ab.model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

//    String id = UUID.randomUUID().toString();

    private int id;
    private String firstName;
    private String secondName;
    private String phoneNumber;
    private String address;
    private String email;


    public User(int id, String firstName, String secondName, String phoneNumber, String address, String email) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                firstName.equals(user.firstName) &&
                secondName.equals(user.secondName) &&
                phoneNumber.equals(user.phoneNumber) &&
                address.equals(user.address) &&
                email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, phoneNumber, address, email);
    }

}
