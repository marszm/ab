package com.addressbook.ab;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class AbApplication {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        User user = createUserList();

        try {
            objectMapper.writeValue(new File("C:\\user.json"), user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SpringApplication.run(AbApplication.class, args);
    }
    private static User createUserList(){
        User user1 = new User();
        user1.setName("Mariusz");
        user1.setSurname("Szmer");
        User user2 = new User();
        user2.setName("Andrzej");
        user2.setSurname("Kolonk");
        return user2;
    }
}
