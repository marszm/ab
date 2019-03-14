package com.addressbook.ab;

import java.util.ArrayList;
import java.util.List;

public class AddressRegistration {

    private List<User> addressRecords = new ArrayList<User>();

    private static AddressRegistration addressRegistration = null;

    public static AddressRegistration getInstance(){
        if(addressRegistration == null){
            addressRegistration =  new AddressRegistration();
            return addressRegistration;
        }
        else
            return addressRegistration;
    }
    public void addUser(User user){
        addressRecords.add(user);
    }
    public List<User> getAddressRecords(){
        return addressRecords;
    }


}
