package com.addressbook.ab.sorting;

import com.addressbook.ab.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class Sort {

    private final File file = new File("user1.json");
    private Set<User> users;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Sort(){
        users = new LinkedHashSet<>();
    }

    public List<User> sortByFirstName(){

        List<User> userList = new ArrayList<>();

        try {
            InputStream inputStream = new FileInputStream(file);
            TypeReference<Set<User>> listTypeReference = new TypeReference<>() {
            };
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
            TypeReference<Set<User>> listTypeReference = new TypeReference<>() {
            };
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
            TypeReference<Set<User>> listTypeReference = new TypeReference<>() {
            };
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
