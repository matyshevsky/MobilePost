package com.example.controllers;

import com.example.model.mUser;
import com.example.repository.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.mPost;
import com.example.service.PostService;

/**
 * Created by Karol on 11.08.2016.
 */
@Controller
@RequestMapping(value = "/posts")
public class postController {

    @Autowired
    PostService postService;
    @Autowired
    PostDao postdao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllPost(Model model){
        mUser user = (mUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mPost post = postdao.getPostById(user.getPostOffice());
        model.addAttribute("location", post.getName() + " " + post.getZipcode());
        model.addAttribute("postList", postService.getAllPosts());
        return "listPost";
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.GET)
    public String addPost(Model model){
        mPost mpost = new mPost();
        mUser user = (mUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mPost post = postdao.getPostById(user.getPostOffice());
        model.addAttribute("location", post.getName() + " " + post.getZipcode());
        model.addAttribute("mpost", mpost);
        return "addPost";
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public String addPost(@ModelAttribute(value="mpost") mPost mpost){
        postService.addPost(mpost);

        return "redirect:/posts/list";
    }

	@RequestMapping("/edit")
	public String edit(@RequestParam(value = "id") Long id, Model model) {
        mUser user = (mUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mPost post = postdao.getPostById(user.getPostOffice());
        model.addAttribute("location", post.getName() + " " + post.getZipcode());
		model.addAttribute("mpost", postService.getPostById(id));
		return "editPost";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String update(@ModelAttribute("mpost") mPost post) {
		postService.update(post);
		return "redirect:list";
	}

    @RequestMapping("/delete")
    public String remove(@RequestParam(value = "id") Long id) {
        postService.delete(id);
        return "redirect:list";
    }

}
