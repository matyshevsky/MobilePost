package com.example.controllers;

import com.example.model.mPost;
import com.example.model.mTypes;
import com.example.model.mUser;
import com.example.repository.PostDao;
import com.example.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Karol on 10.08.2016.
 */
@Controller
@RequestMapping(value = "/types")
public class typesController {

    @Autowired
    TypesService typesService;
    @Autowired
    PostDao postdao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllTypes(Model model){
        mUser user = (mUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mPost post = postdao.getPostById(user.getPostOffice());
        model.addAttribute("location", post.getName() + " " + post.getZipcode());
        model.addAttribute("typesList", typesService.getAllTypes());
        return "typesList";
    }

    @RequestMapping(value = "/addTypes", method = RequestMethod.GET)
    public String addUser(Model model){
        mUser user = (mUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mPost post = postdao.getPostById(user.getPostOffice());
        model.addAttribute("location", post.getName() + " " + post.getZipcode());
        mTypes mtype = new mTypes();
        model.addAttribute("mtype", mtype);
        return "addTypes";
    }

    @RequestMapping(value = "/addTypes", method=RequestMethod.POST)
    public String addUser(@ModelAttribute(value="mtype") mTypes mtype){
        typesService.addType(mtype);
        return "redirect:/types/list";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam(value = "id") Long id, Model model) {
        mUser user = (mUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mPost post = postdao.getPostById(user.getPostOffice());
        model.addAttribute("location", post.getName() + " " + post.getZipcode());
        model.addAttribute("mtype", typesService.getPostById(id));
        return "editTypes";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String update(@ModelAttribute("mtype") mTypes type) {
        typesService.update(type);
        return "redirect:list";
    }

    @RequestMapping("/delete")
    public String remove(@RequestParam(value = "id") Long id) {
        typesService.delete(id);
        return "redirect:list";
    }

}
