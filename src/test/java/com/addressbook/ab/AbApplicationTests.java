package com.addressbook.ab;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AbApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Test
    public void addUser() {
        User user1 = new User(UUID.randomUUID(),"Jan","Kowalski","666525111","Kielce","jan@wp.pl");
        User user2 = new User(UUID.randomUUID(),"Andrzej","Iksinski","693852741","Krakow","andrzej@wp.pl");
        User user3 = new User(UUID.randomUUID(),"Marta","Marecka","888456147","Warszawa","marta@wp.pl");
        UserDAO userDAO = new UserDAO();
        userDAO.addUser(user1);
        userDAO.addUser(user2);
        userDAO.addUser(user3);

    }

}
