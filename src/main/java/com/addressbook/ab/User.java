package com.addressbook.ab;


import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private static AtomicInteger nextID = new AtomicInteger(1);

    private int id;
    private String firstName;
    private String secondName;
    private String phoneNumber;
    private String address;
    private String email;


    public User() {
    }

    public User(int id, String firstName, String secondName, String phoneNumber, String address, String email) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    User(String firstName, String secondName, String phoneNumber, String address, String email ) {
        this(nextID.getAndIncrement(), firstName, secondName, phoneNumber, email, address);
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
}
