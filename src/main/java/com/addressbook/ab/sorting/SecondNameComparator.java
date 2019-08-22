package com.addressbook.ab.sorting;

import com.addressbook.ab.model.User;

import java.util.Comparator;

public class SecondNameComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getSecondName().compareTo(o2.getSecondName());
    }
}
