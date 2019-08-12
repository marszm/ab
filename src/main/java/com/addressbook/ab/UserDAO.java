package com.addressbook.ab;

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

    Scanner in = new Scanner(System.in);
    ObjectMapper objectMapper = null;
    File file = new File("C:\\user1.json");
    List<User> users = null;
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
    TypeReference<List<User>> listTypeReference = new TypeReference<List<User>>() {};


    public List<User> showFile(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("C:\\user1.json"));
            TypeReference<List<User>> listTypeReference = new TypeReference<List<User>>() {};

            users = objectMapper.readValue(inputStream, listTypeReference);
            for(User user : users) {
                System.out.println(user.getFirstName() + " " +
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

    public User addUser(User user){
        TypeReference<List<User>> listTypeReference = new TypeReference<List<User>>() {};
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("C:\\user1.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        fileExist(file);
        try {
            users = objectMapper.readValue(inputStream, listTypeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        users.add(user);
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), user);
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



    public void editData(){

        try {
            users = objectMapper.readValue(file, listTypeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }

        users.forEach(usr -> System.out.println(("id: " + usr.getId() + " , " +
                "imie: " + usr.getFirstName() + " , " +
                "nazwisko: " + usr.getSecondName() + " , " +
                "numer tel.: " + usr.getPhoneNumber() + " , " +
                "adres: " + usr.getAddress() + " , " +
                "email: " + usr.getEmail())));

        System.out.println("podaj id uzytkownika, ktorego chcesz edytowac: ");
        System.out.println("id> ");
//        UUID idEdit = 0;
        in.nextLine();
        System.out.println("nowe imie> ");
        String newFirstName = in.nextLine();
        System.out.println("noew nazwisko> ");
        String newSecondName = in.nextLine();
        System.out.println("nowe numer tel.> ");
        String newPhoneNumber = in.nextLine();
        System.out.println("nowy adres> ");
        String newAddress = in.nextLine();
        System.out.println("nowy email> ");
        String newEmail = in.nextLine();

        User user1 = new User(UUID.randomUUID(), newFirstName, newSecondName, newPhoneNumber, newAddress, newEmail);
        users.remove(UUID.randomUUID());
        users.add(user1);

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(){

        try {
            users = objectMapper.readValue(file, listTypeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }

        users.forEach(usr -> System.out.println("id: " + usr.getId() + " , " +
                "imie: " + usr.getFirstName() + " , " +
                "nazwisko: " + usr.getSecondName() + " , " +
                "numer tel.: " + usr.getPhoneNumber() + " , " +
                "adres: " + usr.getAddress() + " , " +
                "email: " + usr.getEmail()));

        System.out.println("podaj id uzytkownika, ktorego chcesz usunac: ");
        System.out.println("id> ");
        int idUser = in.nextInt();
        System.out.println("usunieto !!! ");
        users.remove(idUser - 1);

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortByFirstName(){

        try {
            users = objectMapper.readValue(file, listTypeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(users, new NameComparator());

        users.forEach(usr -> System.out.println("id: " + usr.getId() + " , " +
                "imie: " + usr.getFirstName() + " , " +
                "nazwisko: " + usr.getSecondName() + " , " +
                "numer tel.: " + usr.getPhoneNumber() + " , " +
                "adres: " + usr.getAddress() + " , " +
                "email: " + usr.getEmail()));
    }

    public void sortBySecondName(){

        try {
            users = objectMapper.readValue(file, listTypeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(users, new SurnameComparator());

        users.forEach(usr -> System.out.println("id: " + usr.getId() + " , " +
                "imie: " + usr.getFirstName() + " , " +
                "nazwisko: " + usr.getSecondName() + " , " +
                "numer tel.: " + usr.getPhoneNumber() + " , " +
                "adres: " + usr.getAddress() + " , " +
                "email: " + usr.getEmail()));

    }

    public void sortByEmail(){

        try {
            users = objectMapper.readValue(file, listTypeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(users, new EmailComparator());

        users.forEach(usr -> System.out.println("id: " + usr.getId() + " , " +
                "imie: " + usr.getFirstName() + " , " +
                "nazwisko: " + usr.getSecondName() + " , " +
                "numer tel.: " + usr.getPhoneNumber() + " , " +
                "adres: " + usr.getAddress() + " , " +
                "email: " + usr.getEmail()));

    }
}
