package com.addressbook.ab;

import java.util.Comparator;

public class SurnameComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.getSecondName().compareTo(o2.getSecondName());
    }
}
