package com.addressbook.ab.controller;

import com.addressbook.ab.DAO.UserDAO;
import com.addressbook.ab.model.User;
import com.addressbook.ab.sorting.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ControllerAB {

    Sort sort = new Sort();
    private UserDAO userDAO = new UserDAO();

    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user)
    {
        return userDAO.addUser(user);
    }

    @GetMapping("/read")
    public Set<User> readAllUsers() {

        return  userDAO.showFile();
    }

    @PutMapping("/update")
    User update(@Valid @RequestBody User user) {

        return userDAO.editUser(user);

    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Integer id) {

        userDAO.deleteUser(id);

    }

    @GetMapping("/sortByFirstName")
    public List<User> sortByFirstName()
    {
        return  sort.sortByFirstName();
    }

    @GetMapping("/sortBySecondName")
    public List<User> sortBySecondName()
    {
        return  sort.sortBySecondName();
    }

    @GetMapping("/sortByEmail")
    public List<User> sortByEmail()
    {
        return  sort.sortByEmail();
    }


}
