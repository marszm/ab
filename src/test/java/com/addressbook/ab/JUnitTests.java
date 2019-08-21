package com.addressbook.ab;

import com.addressbook.ab.DAO.UserDAO;
import com.addressbook.ab.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class JUnitTests {

    @Autowired
    UserDAO userDAO = new UserDAO();

    User user1 = new User(1,"Jan","Kowalski","666525111","Kielce","jan@wp.pl");
    User user2 = new User(2,"Andrzej","Iksinski","693852741","Krakow","andrzej@wp.pl");
    User user3 = new User(3,"Marta","Marecka","888456147","Warszawa","marta@wp.pl");
    User user4 = new User(4,"Anna","Marecka","888456147","Warszawa","marta@wp.pl");

    @Test
    public void create() {

        userDAO.addUser(user1);
        userDAO.addUser(user2);
        userDAO.addUser(user3);
        userDAO.addUser(user4);

    }

}
