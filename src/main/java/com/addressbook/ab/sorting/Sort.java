package com.addressbook.ab.sorting;

import com.addressbook.ab.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;

public class Sort {

    private File file = new File("C:\\user1.json");
    private Set<User> users;
    private ObjectMapper objectMapper = new ObjectMapper();

    private static Sort sort = null;

    public Sort(){
        users = new LinkedHashSet<>();
    }

    public static Sort getInstance(){
        if(sort == null) {
            sort = new Sort();
            return sort;
        }
        else {
            return sort;
        }
    }

    public List<User> sortByFirstName(){

        List<User> userList = new ArrayList<>();

        try {
            InputStream inputStream = new FileInputStream(file);
            TypeReference<Set<User>> listTypeReference = new TypeReference<Set<User>>() {};
            users = objectMapper.readValue(inputStream, listTypeReference);
            userList = new ArrayList<>(users);
            userList.sort(new FirstNameComparator());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), userList);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(userList);
        return userList;
    }

    public List<User> sortBySecondName(){

        List<User> userList = new ArrayList<>();

        try {
            InputStream inputStream = new FileInputStream(file);
            TypeReference<Set<User>> listTypeReference = new TypeReference<Set<User>>() {};
            users = objectMapper.readValue(inputStream, listTypeReference);
            userList = new ArrayList<>(users);
            userList.sort(new SecondNameComparator());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), userList);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(userList);
        return userList;

    }

    public List<User> sortByEmail(){

        List<User> userList = new ArrayList<>();

        try {
            InputStream inputStream = new FileInputStream(file);
            TypeReference<Set<User>> listTypeReference = new TypeReference<Set<User>>() {};
            users = objectMapper.readValue(inputStream, listTypeReference);
            userList = new ArrayList<>(users);
            userList.sort(new EmailComparator());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), userList);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(userList);
        return userList;

    }

}
