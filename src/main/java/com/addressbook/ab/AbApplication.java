package com.addressbook.ab;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.*;

@SpringBootApplication
public class AbApplication {

    public static void main(String[] args) throws FileNotFoundException {


        ObjectMapper objectMapper = new ObjectMapper();
        Scanner in = new Scanner(System.in);
        File file = new File("C:\\user1.json");
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
        } else {
            List<User> users = new ArrayList<>();
            System.out.println("MENU: 1- dodaj, 2- pokaz,  4- edytuj, 5- usun, 9- limit ksiazki adresowej,  0-run Spring Boot RESTful API");
            String choice;
            do {

                choice = in.nextLine();
                switch (choice) {

                    case "1":
                        //dodaj zytkownika do pliku
                        try {
                            users = objectMapper.readValue(file, new TypeReference<List<User>>() {
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("id> ");
                        int id = in.nextInt();
                        in.nextLine();
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

                        User user = new User(id, firstName, secondName, phoneNumber, address, email);

                        users.add(user);

                        try {
                            objectMapper.writer().writeValue(new FileOutputStream(file, false), users);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;

                    case "2":
                        //pokaz zawartosc pliku
                        try {
                            TypeReference<List<User>> mapType = new TypeReference<List<User>>() {
                            };
                            List<User> jsonToPersonList = objectMapper.readValue(file, mapType);

                            jsonToPersonList.forEach(usr -> System.out.println("id: " + usr.getId() + " , " +
                                    "imie: " + usr.getFirstName() + " , " +
                                    "nazwisko: " + usr.getSecondName() + " , " +
                                    "numer tel.: " + usr.getPhoneNumber() + " , " +
                                    "adres: " + usr.getAddress() + " , " +
                                    "email: " + usr.getEmail()));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;

                    case "3":
                        //sort by name
                        try {
                            TypeReference<List<User>> mapType = new TypeReference<List<User>>() {
                            };

                            List<User> sortByName = objectMapper.readValue(file, mapType);
                            Collections.sort(sortByName, new NameComparator());

                            sortByName.forEach(usr -> System.out.println("id: " + usr.getId() + " , " +
                                    "imie: " + usr.getFirstName() + " , " +
                                    "nazwisko: " + usr.getSecondName() + " , " +
                                    "numer tel.: " + usr.getPhoneNumber() + " , " +
                                    "adres: " + usr.getAddress() + " , " +
                                    "email: " + usr.getEmail()));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;

                    case "4":

                        //edycja danych
                        TypeReference<List<User>> mT = new TypeReference<List<User>>(){};
                        List<User> editList = null;

                        try {
                            editList = objectMapper.readValue(file, mT);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        editList.forEach(usr -> System.out.println(("id: " + usr.getId() + " , " +
                                "imie: " + usr.getFirstName() + " , " +
                                "nazwisko: " + usr.getSecondName() + " , " +
                                "numer tel.: " + usr.getPhoneNumber() + " , " +
                                "adres: " + usr.getAddress() + " , " +
                                "email: " + usr.getEmail())));

                        System.out.println("podaj id uzytkownika, ktorego chcesz edytowac: ");
                        System.out.println("id> ");
                        int idEdit = in.nextInt();
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

                        User user1 = new User(idEdit, newFirstName, newSecondName, newPhoneNumber, newAddress, newEmail);
                        editList.remove(idEdit - 1);
                        editList.add(idEdit - 1, user1);

                        try {
                            objectMapper.writer().writeValue(new FileOutputStream(file, false), editList);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;

                    case "5":
                        //usun
                        TypeReference<List<User>> mapType = new TypeReference<List<User>>() {
                        };
                        List<User> jsonToPersonList = null;

                        try {
                            jsonToPersonList = objectMapper.readValue(file, mapType);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        jsonToPersonList.forEach(usr -> System.out.println("id: " + usr.getId()+" , "+
                                "imie: " + usr.getFirstName()+" , "+
                                "nazwisko: "+usr.getSecondName()+" , "+
                                "numer tel.: "+usr.getPhoneNumber()+" , "+
                                "adres: "+usr.getAddress()+" , "+
                                "email: "+usr.getEmail()));

                        System.out.println("podaj id uzytkownika, ktorego chcesz usunac: ");
                        System.out.println("id> ");
                        int idUser = in.nextInt();
                        System.out.println("usunieto !!! ");
                        jsonToPersonList.remove(idUser - 1);

                        try {
                            objectMapper.writer().writeValue(new FileOutputStream(file, false), jsonToPersonList);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;

                    case "9":
                        //wczytaj limit wpisow z pliku application.properties

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
                            throw new FileNotFoundException("application.properties '" + propFileName + "' nie znaleziono");
                        }

                        int limit = Integer.parseInt(prop.getProperty("limit"));

                        System.out.println("limit wpisow ustwiono na: " + limit);
                        break;

                    case "0":

                        SpringApplication.run(AbApplication.class, args);

                        break;

                    default:
                        System.out.println("MENU: 1- dodaj, 2- pokaz,  4- edytuj, 5- usun, 9-limit,  0-run Spring Boot RESTful API");
                }
            } while (!choice.equals("0"));

        }
    }
}