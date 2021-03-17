package com.addressbook.ab.controller;

import com.addressbook.ab.DAO.UserDAO;
import com.addressbook.ab.model.User;
import com.addressbook.ab.sorting.Sort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ControllerAB {

    private final Sort sort;
    private final UserDAO userDAO;

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userDAO.addUser(user);
    }

    @GetMapping("/users")
    public Set<User> readAllUsers() {

        return userDAO.showFile();
    }

    @PutMapping("/users")
    User update(@Valid @RequestBody User user) {

        return userDAO.editUser(user);

    }

    @DeleteMapping("/users/{id}")
    void delete(@PathVariable Integer id) {

        userDAO.deleteUser(id);

    }

    @GetMapping("/sortByFirstName")
    public List<User> sortByFirstName() {
        return sort.sortByFirstName();
    }

    @GetMapping("/sortBySecondName")
    public List<User> sortBySecondName() {
        return sort.sortBySecondName();
    }

    @GetMapping("/sortByEmail")
    public List<User> sortByEmail() {
        return sort.sortByEmail();
    }


}
