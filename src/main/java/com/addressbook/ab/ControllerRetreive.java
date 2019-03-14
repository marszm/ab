package com.addressbook.ab;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ControllerRetreive {


    @RequestMapping(method = RequestMethod.GET, value = "/alladresses")

    @ResponseBody
    public List<User> getAllAddresses(){
        return AddressRegistration.getInstance().getAddressRecords();
    }

}
