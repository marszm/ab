package com.addressbook.ab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerRegistration {

    @RequestMapping(method = RequestMethod.POST, value = "/add")

    @ResponseBody
    public UserReply createUser(@RequestBody User user){
        UserReply userReply = new UserReply();
        AddressRegistration.getInstance().addUser(user);
        userReply.setName(user.getFirstName());
//        userReply.setSurname(user.getSurname());
//        userReply.setAddress(user.getAddress());
//        userReply.setEmail(user.getEmail());
//        userReply.setPhoneNumber(user.getPhoneNumber());
        userReply.setBookingStatus("OK");
        return userReply;
    }

}
