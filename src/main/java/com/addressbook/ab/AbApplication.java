package com.addressbook.ab;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.Scanner;

@SpringBootApplication
public class AbApplication {

    public static void main(String[] args) {


        ObjectMapper objectMapper = new ObjectMapper();
        Scanner in = new Scanner(System.in);
        File file = new File("C:\\user1.json");

        System.out.println("1 - add person");
        System.out.println("4 - close");
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

                System.out.println("1 - add person");
                System.out.println("4 - close");

                User user = new User(firstName, secondName, phoneNumber, address, email);

                try{
                    JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator(new FileOutputStream(file, true));
                    objectMapper.writeValue(jsonGenerator, user);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

                case  "4":
                      SpringApplication.run(AbApplication.class, args);
//                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter number from 1 to 4");
            }
        }while (!choice.equals("4"));

    }
}
