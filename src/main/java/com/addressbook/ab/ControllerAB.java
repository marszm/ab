package com.addressbook.ab;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerAB {

    private UserDAO userDAO = new UserDAO();

//    @RequestMapping(method = RequestMethod.GET, value = "/api/ab/all")
    @GetMapping("/api/ab/all")

    @ResponseBody
    public List<User> findAll(){
//        System.out.println(userDAO.userList);
        return userDAO.showFile();
    }

//    @PostMapping("/api/ab/add")

//    @ResponseBody
//    public User addUser() {
//            return userDAO.addUser();
//    }

}
