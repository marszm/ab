package com.addressbook.ab.DAO;

import com.addressbook.ab.AbApplication;
import com.addressbook.ab.model.User;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class UserDAO {

    File file = new File("C:\\user1.json");
    List<User> users;
    private static UserDAO userDAO = null;

    private UserDAO(){
        users = new ArrayList<User>();
    }

    public static UserDAO getInstance(){
        if(userDAO == null) {
            userDAO = new UserDAO();
            return userDAO;
        }
        else {
            return userDAO;
        }
    }

    public List<User> sortByFirstName(){
        users.sort(Comparator.comparing(User::getFirstName));
        return users;
    }

    public List<User> sortBySecondName(){
        users.sort(Comparator.comparing(User::getSecondName));
        return users;
    }

    public List<User> sortByEmail(){
        users.sort(Comparator.comparing(User::getEmail));
        return users;
    }

    public List<User> showFile(){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("C:\\user1.json"));
            TypeReference<List<User>> listTypeReference = new TypeReference<List<User>>() {};
            users = objectMapper.readValue(inputStream, listTypeReference);
            for(User user : users) {
                System.out.println(user.getId() + " " +
                        user.getFirstName() + " " +
                        user.getSecondName()+ " " +
                        user.getEmail() + " " +
                        user.getAddress() + " " +
                        user.getPhoneNumber());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User addUser(User user) {

        fileExist(file);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(file);
            TypeReference<List<User>> listTypeReference = new TypeReference<List<User>>() {};
            users = objectMapper.readValue(inputStream, listTypeReference);
            users.add(user);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), users);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void fileExist(File file) {

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

    public void loadDataBaseSizeLimit(){

        Properties prop = new Properties();
        String propFileName = "application.properties";
        InputStream inputStream = AbApplication.class.getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            try {
                prop.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                throw new FileNotFoundException("application.properties" + propFileName + "nie znaleziono");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        int limit = Integer.parseInt(prop.getProperty("limit"));
    }

    public User editUser(User user){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(file);
            TypeReference<List<User>> listTypeReference = new TypeReference<List<User>>() {};
            users = objectMapper.readValue(inputStream, listTypeReference);
            users.remove(user.getId()-1);
            users.add(user.getId()-1,user);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), users);
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void deleteUser(int id){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(file);
            TypeReference<List<User>> listTypeReference = new TypeReference<List<User>>() {};
            users = objectMapper.readValue(inputStream, listTypeReference);
            users.remove(id-1);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), users);
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
