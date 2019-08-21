package com.addressbook.ab.controler;

import com.addressbook.ab.DAO.UserDAO;
import com.addressbook.ab.model.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ControllerAB {


    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user)
    {
        return UserDAO.getInstance().addUser(user);
    }

    @GetMapping("/read")
    public Set<User> readAllUsers() {
        return  UserDAO.getInstance().showFile();
    }

    @PutMapping("/update")
    User update(@Valid @RequestBody User user) {
        return UserDAO.getInstance().editUser(user);
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Integer id) {
        UserDAO.getInstance().deleteUser(id);
    }

    @GetMapping("/sortByFirstName")
    public Set<User> sortByFirstName()
    {
        return  UserDAO.getInstance().sortByFirstName();
    }

    @GetMapping("/sortBySecondName")
    public Set<User> sortBySecondName()
    {
        return  UserDAO.getInstance().sortBySecondName();
    }

    @GetMapping("/sortByEmail")
    public Set<User> sortByEmail()
    {
        return  UserDAO.getInstance().sortByEmail();
    }


}
