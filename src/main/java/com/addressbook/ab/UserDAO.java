package com.addressbook.ab;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;

public class UserDAO {

    Scanner in = new Scanner(System.in);
    ObjectMapper objectMapper = new ObjectMapper();
    File file = new File("C:\\user1.json");
    List<User> userList = new ArrayList<>();
    TypeReference typeReference = new TypeReference<List<User>>(){};

   /* public User inputData(){
        System.out.println("imie> ");
        String firstName = in.nextLine();
        System.out.println("nazwisko> ");
        String secondName = in.nextLine();
        System.out.println("numer tel.> ");
        String phoneNumber = in.nextLine();
        System.out.println("adres> ");
        String address = in.nextLine();
        System.out.println("email> ");
        String email = in.nextLine();

        return  new User(id, firstName,secondName,phoneNumber,address,email);
    }*/

    public void addUser(User user){
        fileExist(file);
        try {
            userList = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        userList.add(user);
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public List<User> showFile(){

        try {
            userList = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }

        userList.forEach(usr -> System.out.println("id: " + usr.getId() + " , " +
                    "imie: " + usr.getFirstName() + " , " +
                    "nazwisko: " + usr.getSecondName() + " , " +
                    "numer tel.: " + usr.getPhoneNumber() + " , " +
                    "adres: " + usr.getAddress() + " , " +
                    "email: " + usr.getEmail()));

        return userList;
    }

    public void editData(){

        try {
            userList = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }

        userList.forEach(usr -> System.out.println(("id: " + usr.getId() + " , " +
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
        userList.remove(UUID.randomUUID());
        userList.add(user1);

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(){

        try {
            userList = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }

        userList.forEach(usr -> System.out.println("id: " + usr.getId() + " , " +
                "imie: " + usr.getFirstName() + " , " +
                "nazwisko: " + usr.getSecondName() + " , " +
                "numer tel.: " + usr.getPhoneNumber() + " , " +
                "adres: " + usr.getAddress() + " , " +
                "email: " + usr.getEmail()));

        System.out.println("podaj id uzytkownika, ktorego chcesz usunac: ");
        System.out.println("id> ");
        int idUser = in.nextInt();
        System.out.println("usunieto !!! ");
        userList.remove(idUser - 1);

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(file, false), userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortByFirstName(){

        try {
            userList = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(userList, new NameComparator());

        userList.forEach(usr -> System.out.println("id: " + usr.getId() + " , " +
                "imie: " + usr.getFirstName() + " , " +
                "nazwisko: " + usr.getSecondName() + " , " +
                "numer tel.: " + usr.getPhoneNumber() + " , " +
                "adres: " + usr.getAddress() + " , " +
                "email: " + usr.getEmail()));
    }

    public void sortBySecondName(){

        try {
            userList = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(userList, new SurnameComparator());

        userList.forEach(usr -> System.out.println("id: " + usr.getId() + " , " +
                "imie: " + usr.getFirstName() + " , " +
                "nazwisko: " + usr.getSecondName() + " , " +
                "numer tel.: " + usr.getPhoneNumber() + " , " +
                "adres: " + usr.getAddress() + " , " +
                "email: " + usr.getEmail()));

    }

    public void sortByEmail(){

        try {
            userList = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(userList, new EmailComparator());

        userList.forEach(usr -> System.out.println("id: " + usr.getId() + " , " +
                "imie: " + usr.getFirstName() + " , " +
                "nazwisko: " + usr.getSecondName() + " , " +
                "numer tel.: " + usr.getPhoneNumber() + " , " +
                "adres: " + usr.getAddress() + " , " +
                "email: " + usr.getEmail()));

    }
}
