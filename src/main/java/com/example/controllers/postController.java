package com.example.controllers;

import com.example.model.mPost;
import com.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Karol on 11.08.2016.
 */
@Controller
@RequestMapping(value = "/posts")
public class postController {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllPost(Model model){
        model.addAttribute("postList", postService.getAllPosts());
        return "listPost";
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.GET)
    public String addPost(Model model){
        mPost mpost = new mPost();
        model.addAttribute("mpost", mpost);
        return "addPost";
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public String addPost(@ModelAttribute(value="mpost") mPost mpost){
        postService.addPost(mpost);

        return "redirect:/posts/list";
    }


}
