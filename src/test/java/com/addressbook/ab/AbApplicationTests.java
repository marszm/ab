package com.addressbook.ab;

import com.addressbook.ab.DAO.UserDAO;
import com.addressbook.ab.model.User;
import com.addressbook.ab.sorting.Sort;
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
    Sort sort;

    @Test
    public void contextLoads() {
    }

    @Test
    public void create1() {

        User user1 = new User(1, "Jan", "Kowalski", "666525111", "Kielce", "jan@wp.pl");
        User user2 = new User(1, "Jan", "Kowalski", "666525111", "Kielce", "jan@wp.pl");
        userDAO.addUser(user1);
        userDAO.addUser(user2);

    }

    @Test
    public void create2() {

        User user2 = new User(2, "Andrzej", "Iksinski", "693852741", "Krakow", "andrzej@wp.pl");
        userDAO.addUser(user2);

    }

    @Test
    public void create3() {

        User user3 = new User(3, "Marta", "Marecka", "888456147", "Warszawa", "marta@wp.pl");
        userDAO.addUser(user3);

    }

    @Test
    public void create4() {

        User user4 = new User(4, "Anna", "Marecka", "888456147", "Warszawa", "marta@wp.pl");
        userDAO.addUser(user4);

    }

    @Test
    public void create() {

        User user1 = new User(1, "Jan", "Kowalski", "666525111", "Kielce", "jan@wp.pl");
        User user2 = new User(2, "Andrzej", "Iksinski", "693852741", "Krakow", "andrzej@wp.pl");
        User user3 = new User(3, "Marta", "Marecka", "888456147", "Warszawa", "marta@wp.pl");
        User user4 = new User(4, "Anna", "Marecka", "888456147", "Warszawa", "marta@wp.pl");
        userDAO.addUser(user1);
        userDAO.addUser(user2);
        userDAO.addUser(user3);
        userDAO.addUser(user4);

    }

    @Test
    public void delete() {

        userDAO.deleteUser(3);

    }

    @Test
    public void read() {

        userDAO.showFile();

    }

    @Test
    public void update() {

        User user5 = new User(1, "Ggg", "BRZECZYSZCZYKIEWICZ", "000000000", "POZNAN", "GB@wp.pl");
        userDAO.editUser(user5);
    }

    @Test
    public void sortByFirstName() {

        sort.sortByFirstName();

    }

    @Test
    public void sortBySecondName() {

        sort.sortBySecondName();

    }

    @Test
    public void sortByEmail() {

        sort.sortByEmail();

    }

}
