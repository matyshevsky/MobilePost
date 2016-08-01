package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Karol on 01.08.2016.
 */
@Controller
@RequestMapping(value = "/registry")
public class registryController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "addParcel";
    }


}
