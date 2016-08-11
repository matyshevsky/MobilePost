package com.example.controllers;

import com.example.model.mTypes;
import com.example.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Karol on 10.08.2016.
 */
@Controller
@RequestMapping(value = "/types")
public class typesController {

    @Autowired
    TypesService typesService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllTypes(Model model){
        model.addAttribute("typesList", typesService.getAllTypes());
        return "typesList";
    }

    @RequestMapping(value = "/addTypes", method = RequestMethod.GET)
    public String addUser(Model model){
        mTypes mtype = new mTypes();
        model.addAttribute("mtype", mtype);
        return "addTypes";
    }

    @RequestMapping(value = "/addTypes", method=RequestMethod.POST)
    public String addUser(@ModelAttribute(value="mtype") mTypes mtype){

        typesService.addType(mtype);

        return "redirect:/types/list";
    }

}
