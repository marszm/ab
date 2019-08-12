package com.addressbook.ab;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerAB {

    @Autowired
    private UserDAO userDAO;
//    private File file;

    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user){
        return UserDAO.getInstance().addUser(user);
    }

    @GetMapping("/read")
//    @RequestMapping(value = "read")
    public List<User>  readAllUsers() {
       return  UserDAO.getInstance().showFile();
    }

}
