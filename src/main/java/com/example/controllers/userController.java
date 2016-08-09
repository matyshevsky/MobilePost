package com.example.controllers;

import com.example.repository.UserDao;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Karol on 09.08.2016.
 */
@Controller
@RequestMapping(value = "/users")
public class userController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String getAllUser(Model model){
        model.addAttribute("userList",userService.getAllUser());
        return "list";

    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(){
        return "addUser";
    }
}
