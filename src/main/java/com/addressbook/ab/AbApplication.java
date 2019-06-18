package com.addressbook.ab;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.*;

@SpringBootApplication
public class AbApplication {

    public static void main(String[] args) {

//        UserDAO userDAO = new UserDAO();
//        User user = new User();

        SpringApplication.run(AbApplication.class, args);

//        if (args[0].equals("addUser"))
//            userDAO.addUser(user);
        /*UserDAO userDAO = new UserDAO();
        Scanner in = new Scanner(System.in);

            System.out.println("MENU: 1- dodaj do pliku, 2- pokaz plik, 3- edytuj dane, 4- usun, 5- sort wg imienia,  " +
                    "6- sort wg nazwiska,  7- sort wg adresu email  9- limit ksiazki adresowej,  0-run Spring Boot RESTful API");
            String choice;
            do {

                choice = in.nextLine();
                switch (choice) {

                    case "1":
                        //dodaj zytkownika do pliku

                        userDAO.addUser();
                        break;

                    case "2":
                        userDAO.showFile();
                        break;
                        //pokaz zawartosc pliku


                    case "3":

                        //edycja danych
                        userDAO.editData();
                        break;

                    case "4":

                        //usun
                        userDAO.deleteUser();
                        break;

                    case "5":

                        //sort by name
                        userDAO.sortByFirstName();
                        break;

                    case "6":
                        //sort by second name
                        userDAO.sortBySecondName();
                        break;

                    case "7":
                        //sort by email
                        userDAO.sortByEmail();
                        break;

                    case "9":
                        //wczytaj limit wpisow z pliku application.properties

                        System.out.println("Limit bd ustawiona na:  uzytkownikow !!!");

                        break;
                    case "0":

                        SpringApplication.run(AbApplication.class, args);

                        break;

                    default:
                        System.out.println("MENU: 1- dodaj do pliku, 2- pokaz plik, 3- edytuj dane, 4- usun, 5- sort wg imienia,  " +
                                "6- sort wg nazwiska,  7- sort wg adresu email  9- limit ksiazki adresowej,  0-run Spring Boot RESTful API");
                }
            } while (!choice.equals("0"));
*/
    }
}