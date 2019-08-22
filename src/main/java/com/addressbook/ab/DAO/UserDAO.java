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
    Set<User> users;
    public static UserDAO userDAO = null;

    public UserDAO(){
        users = new LinkedHashSet<>();
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

        List<User> userList = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(file);
            TypeReference<Set<User>> listTypeReference = new TypeReference<Set<User>>() {};
            users = objectMapper.readValue(inputStream, listTypeReference);
            userList = new ArrayList<>(users);
            Collections.sort(userList, new FirstNameComparator());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), userList);
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
        System.out.println(userList);
       return userList;
    }

    public List<User> sortBySecondName(){

        List<User> userList = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(file);
            TypeReference<Set<User>> listTypeReference = new TypeReference<Set<User>>() {};
            users = objectMapper.readValue(inputStream, listTypeReference);
            userList = new ArrayList<>(users);
            Collections.sort(userList, new SecondNameComparator());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), userList);
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
        System.out.println(userList);
        return userList;

    }

    public List<User> sortByEmail(){

        List<User> userList = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(file);
            TypeReference<Set<User>> listTypeReference = new TypeReference<Set<User>>() {};
            users = objectMapper.readValue(inputStream, listTypeReference);
            userList = new ArrayList<>(users);
            Collections.sort(userList, new EmailComparator());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), userList);
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
        System.out.println(userList);
        return userList;

    }

    public Set<User> showFile(){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("C:\\user1.json"));
            TypeReference<Set<User>> listTypeReference = new TypeReference<Set<User>>() {};
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
                TypeReference<Set<User>> listTypeReference = new TypeReference<Set<User>>() {};
                users = objectMapper.readValue(inputStream, listTypeReference);
                if(users.size() < dataBaseSizeLimit())
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

    public int dataBaseSizeLimit(){

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
        return limit;
    }

    public User editUser(User user){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(file);
            TypeReference<Set<User>> listTypeReference = new TypeReference<Set<User>>() {};
            users = objectMapper.readValue(inputStream, listTypeReference);
//            users.remove(user);
            users.removeIf(s -> s.getId() == user.getId());
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

    public void deleteUser(int id){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(file);
            TypeReference<Set<User>> listTypeReference = new TypeReference<Set<User>>() {};
            users = objectMapper.readValue(inputStream, listTypeReference);
            users.removeIf(s -> s.getId() == id);
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
