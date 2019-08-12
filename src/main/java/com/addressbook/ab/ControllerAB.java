package com.addressbook.ab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerAB {

    @Autowired
    private UserDAO userDAO;

    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user)
    {
        return UserDAO.getInstance().addUser(user);
    }

    @GetMapping("/read")
    public List<User>  readAllUsers() {
        return  UserDAO.getInstance().showFile();
    }

    @PutMapping("/update/{id}")
    User update(@RequestBody User user) {
        return UserDAO.getInstance().addUser(user);
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Integer id) {
        UserDAO.getInstance().deleteUser(id);
    }



}
