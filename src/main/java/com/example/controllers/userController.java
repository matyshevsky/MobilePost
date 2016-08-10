package com.example.controllers;

import com.example.model.mUser;
import com.example.repository.UserDao;
import com.example.service.UserService;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

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
    public String addUser(Model model){
        mUser user = new mUser();
        model.addAttribute("muser", user);
        return "addUser";
    }

    @RequestMapping(value = "/addUser", method=RequestMethod.POST)
    public String addUser(@ModelAttribute(value="user") mUser muser){

        userService.addUser(muser);

        return "redirect:/users/list";
    }

    /*
    @RequestMapping(value="/edit?id={item.id}", method=RequestMethod.GET)
    public String editUser(@PathVariable("id") Long id, Map<Long, Object> model){

        mUser user = userService.getUserById(id);
    }
    */

}
