package com.addressbook.ab.controler;

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
    public List<User> sortByFirstName()
    {
        return  Sort.getInstance().sortByFirstName();
    }

    @GetMapping("/sortBySecondName")
    public List<User> sortBySecondName()
    {
        return  Sort.getInstance().sortBySecondName();
    }

    @GetMapping("/sortByEmail")
    public List<User> sortByEmail()
    {
        return  Sort.getInstance().sortByEmail();
    }


}
