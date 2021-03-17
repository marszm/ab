package com.addressbook.ab.DAO;

import com.addressbook.ab.config.DataBaseLimit;
import com.addressbook.ab.model.User;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class UserDAO {

    private final File file = new File("user1.json");
    private Set<User> users;

    public UserDAO(){
        users = new LinkedHashSet<>();
    }

    public Set<User> showFile(){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream("user1.json");
            TypeReference<Set<User>> listTypeReference = new TypeReference<>() {
            };
            users = objectMapper.readValue(inputStream, listTypeReference);
            for(User user : users) {
                System.out.println(user.getId() + " " +
                        user.getFirstName() + " " +
                        user.getSecondName()+ " " +
                        user.getEmail() + " " +
                        user.getAddress() + " " +
                        user.getPhoneNumber());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User addUser(User user) {

        fileExist(file);
        DataBaseLimit dataBaseLimit = new DataBaseLimit();

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                InputStream inputStream = new FileInputStream(file);
                TypeReference<Set<User>> listTypeReference = new TypeReference<>() {
                };
                users = objectMapper.readValue(inputStream, listTypeReference);
                if(users.size() < dataBaseLimit.dataBaseSizeLimit())
                users.add(user);
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), users);
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        return user;
    }

    public User editUser(User user){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(file);
            TypeReference<Set<User>> listTypeReference = new TypeReference<>() {
            };
            users = objectMapper.readValue(inputStream, listTypeReference);
            users.removeIf(s -> s.getId().equals(user.getId()));
            users.add(user);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), users);
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void deleteUser(int id){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(file);
            TypeReference<Set<User>> listTypeReference = new TypeReference<>() {
            };
            users = objectMapper.readValue(inputStream, listTypeReference);
            users.removeIf(s -> s.getId() == id);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), users);
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fileExist(File file) {

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            JsonFactory jsonFactory = new JsonFactory();
            try {
                JsonGenerator jsonGenerator = jsonFactory.createGenerator(file, JsonEncoding.UTF8);
                jsonGenerator.writeStartArray();
                jsonGenerator.writeEndArray();
                jsonGenerator.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
