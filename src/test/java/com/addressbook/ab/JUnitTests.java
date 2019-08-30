package com.addressbook.ab;

import com.addressbook.ab.DAO.UserDAO;
import com.addressbook.ab.model.User;
import com.addressbook.ab.sorting.Sort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class JUnitTests {

    @Autowired
    UserDAO userDAO = new UserDAO();
    Sort sort = new Sort();

    User user1 = new User(1,"Jan","Kowalski","666525111","Kielce","jan@wp.pl");
    User user2 = new User(2,"Andrzej","Iksinski","693852741","Krakow","andrzej@wp.pl");
    User user3 = new User(3,"Marta","Marecka","888456147","Warszawa","marta@wp.pl");
    User user4 = new User(4,"Anna","Marecka","888456147","Warszawa","marta@wp.pl");


    User user7 = new User(4,"A","M","888456147","Warszawa","marta@wp.pl");

    User user5 = new User(1,"Ggg","BRZECZYSZCZYKIEWICZ","000000000","POZNAN","GB@wp.pl");
    User user6 = new User(1,"G","BRZECZYSZCZYKIEWICZ","000000000","POZNAN","GB@wp.pl");

    @Test
    public void create() {

        userDAO.addUser(user1);
        userDAO.addUser(user2);
        userDAO.addUser(user3);
        userDAO.addUser(user4);
        userDAO.addUser(user7);

    }

    @Test
    public  void read(){

        userDAO.showFile();

    }

    @Test
    public  void update(){



        userDAO.editUser(user6);
//        userDAO.editUser(user5);
    }

    @Test
    public  void sortByFirstName(){

        sort.sortByFirstName();

    }

    @Test
    public  void sortBySecondName(){

        sort.sortBySecondName();

    }

    @Test
    public  void sortByEmail(){

        sort.sortByEmail();

    }

    @Test
    public  void delete(){

        userDAO.deleteUser(2);

    }

}
