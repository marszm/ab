package com.addressbook.ab;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ReferenceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AbApplicationTests {
    @Autowired
    UserDAO userDAO;
    @Test
    public void contextLoads() {
    }
    @Test
    public void addUser() {
        //create
        User user1 = new User(1,"Jan","Kowalski","666525111","Kielce","jan@wp.pl");
        User user2 = new User(2,"Andrzej","Iksinski","693852741","Krakow","andrzej@wp.pl");
        User user3 = new User(3,"Marta","Marecka","888456147","Warszawa","marta@wp.pl");
//        UserDAO userDAO = new UserDAO();
        userDAO.addUser(user1);
        userDAO.addUser(user2);
        userDAO.addUser(user3);
        //update
        //delete

    }
    @Test
    public  void readAllUsers() throws FileNotFoundException {

        userDAO.showFile();
    }

}
