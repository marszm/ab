package com.addressbook.ab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {

    private List<User> usersList = new ArrayList<>();

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    @Override
    public String toString() {
        return "Users{" +
                "usersList=" + usersList +
                '}';
    }
}
