package com.addressbook.ab;

import com.addressbook.ab.DAO.UserDAO;
import com.addressbook.ab.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AbApplicationTests {

    @Autowired
    UserDAO userDAO;

    @Test
    public void contextLoads() {
    }

    @Test
    public void create() {

        User user1 = new User(1,"Jan","Kowalski","666525111","Kielce","jan@wp.pl");
        User user2 = new User(2,"Andrzej","Iksinski","693852741","Krakow","andrzej@wp.pl");
        User user3 = new User(3,"Marta","Marecka","888456147","Warszawa","marta@wp.pl");

        userDAO.addUser(user1);
        userDAO.addUser(user2);
        userDAO.addUser(user3);

    }
    @Test
    public  void delete(){

        userDAO.deleteUser(2);

    }

    @Test
    public  void read(){

        userDAO.showFile();

    }

    @Test
    public  void update(){

        User user4 = new User(1,"G","BRZECZYSZCZYKIEWICZ","000000000","POZNAN","GB@wp.pl");
        User user5 = new User(1,"Ggg","BRZECZYSZCZYKIEWICZ","000000000","POZNAN","GB@wp.pl");
        userDAO.editUser(user4);
        userDAO.editUser(user5);
    }

    @Test
    public  void sortByFirstName(){

        userDAO.sortByFirstName();

    }

    @Test
    public  void sortBySecondName(){

        userDAO.sortBySecondName();

    }

    @Test
    public  void sortByEmail(){

        userDAO.sortByEmail();

    }

}
