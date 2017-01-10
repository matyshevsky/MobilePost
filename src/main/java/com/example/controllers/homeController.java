package com.example.controllers;

import com.example.model.mPost;
import com.example.model.mTypes;
import com.example.model.mUser;
import com.example.repository.PostDao;
import com.example.repository.TypesDao;
import com.example.service.PostService;
import com.example.service.TypesService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Date;

/**
 * Created by SeBB on 31.07.2016.
 */
@Controller
public class homeController {

    @Autowired
    PostDao postdao;
    @Autowired
    TypesService typesService;
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        initialize();
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "login";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        mUser user = (mUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mPost post = postdao.getPostById(user.getPostOffice());
        model.addAttribute("location", post.getName() + " " + post.getZipcode());
        return "index";
    }

    private void initialize(){
        Date dt = new Date();
        mTypes types = typesService.getTypesByCode("Paczka");
        if(types == null){

            types = new mTypes();
            types.setCode("Paczka");
            types.setName("Paczka pocztowa");
            types.setCreateAt(dt);
            typesService.addType(types);

            types = new mTypes();
            types.setCode("List");
            types.setName("List");
            types.setCreateAt(dt);
            typesService.addType(types);

            types = new mTypes();
            types.setCode("Kurier");
            types.setName("Kurier");
            types.setCreateAt(dt);
            typesService.addType(types);
        }

        Collection<mPost> posts = postService.getAllPosts();
        if(posts.isEmpty()){
            mPost post = new mPost();
            post.setName("Urząd pocztowy Warszawa");
            post.setCreateAt(dt);
            post.setCode("UPWar");
            post.setZipcode("00-001");
        }

        Collection<mUser> users = userService.getAllUser();
        if(users.isEmpty()){
            mPost post = postService.getPostByCode("UPWar");
            mUser user = new mUser();
            user.setCreateAt(dt);
            user.setPassword("admin");
            user.setPostOffice(post.getId());
            user.setUsername("admin@up.pl");
        }
    }


}