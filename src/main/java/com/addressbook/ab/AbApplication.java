package com.addressbook.ab;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.*;

@SpringBootApplication
public class AbApplication {

    public static void main(String[] args) {


        ObjectMapper objectMapper = new ObjectMapper();
        Scanner in = new Scanner(System.in);
        File file = new File("C:\\user1.json");
        Map<String, Object> stringObjectMap = new HashMap<>();
        List<Map<String, Object>> userList = new ArrayList<>();
        System.out.println("1 - dodaj");
        System.out.println("2 - pokaz");
        System.out.println("3 - zapisz");
        System.out.println("4 - edytuj");
        System.out.println("0 - wyjdz");
        String choice;
        do {

            choice = in.nextLine();
            switch (choice) {

                case "1":

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

                        System.out.println("1 - dodaj");
                        System.out.println("2 - pokaz");
                        System.out.println("3 - zapisz");
                        System.out.println("4 - edytuj");
                        System.out.println("0 - close");

                        stringObjectMap.put("name", firstName);
                        stringObjectMap.put("surname", secondName);
                        stringObjectMap.put("phoneNumber", phoneNumber);
                        stringObjectMap.put("address", address);
                        stringObjectMap.put("email", email);

                        userList.add(stringObjectMap);

                break;

                case "2":
                    try {
                        List<User> userListPokaz = objectMapper.readValue(file, new TypeReference<List<User>>(){});
                        userListPokaz.forEach(usr->System.out.println(usr));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "3":

                    try{
                        objectMapper.writer().writeValue(new FileOutputStream(file, true),userList);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case  "0":

                      SpringApplication.run(AbApplication.class, args);

                    break;

                default:
                    System.out.println("Enter number from 1 to 4");
            }
        }while (!choice.equals("0"));

    }
}
