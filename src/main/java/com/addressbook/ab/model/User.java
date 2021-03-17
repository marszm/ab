package com.addressbook.ab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Integer id;
    private String firstName;
    private String secondName;
    private String phoneNumber;
    private String address;
    private String email;

}
