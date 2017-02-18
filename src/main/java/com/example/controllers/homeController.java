package com.example.controllers;

import com.example.model.*;
import com.example.repository.PostDao;
import com.example.repository.TypesDao;
import com.example.service.*;
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
    @Autowired
    DeliveryService deliveryService;
    @Autowired
    ProductService productService;

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
        Collection<mDelivery> deliverList = deliveryService.getDeliveryByRecipientZipCode(post.getZipcode());
        int out = deliveryService.getDeliveryByFromOffice(user.getPostOffice()).size();
        int in = deliverList.size();
        int paczka = 0;
        int list = 0;
        int kurier = 0;
        int inne =0;
        Collection<mDelivery> delivers = deliveryService.getDeliveryByFromOffice(user.getPostOffice());
        for (mDelivery x: delivers)
        {
            mProduct product = productService.getProductById(x.getType());
            mTypes type = typesService.getPostById(product.getType());

            switch(type.getCode()){
                case "Paczka":
                    paczka++;
                    break;
                case "List":
                    list++;
                    break;
                case "Kurier":
                    kurier++;
                    break;
                default:
                    inne++;
                    break;
            }
        }

        model.addAttribute("location", post.getName() + " " + post.getZipcode());
        model.addAttribute("out", out);
        model.addAttribute("in", in);
        model.addAttribute("paczka", paczka);
        model.addAttribute("list", list);
        model.addAttribute("kurier", kurier);
        model.addAttribute("inne", inne);
        model.addAttribute("deliverList", deliverList);
        return "index";
    }

    private void initialize(){
        Date dt = new Date();
        Collection<mTypes> typess = typesService.getAllTypes();
        if(typess == null){

            mTypes types = new mTypes();
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
            post.setCode("UP-Waw");
            post.setZipcode("01-001");
            postService.addPost(post);
        }

        Collection<mUser> users = userService.getAllUser();
        if(users.isEmpty()){
            mPost post = postService.getPostByCode("UP-Waw");
            mUser user = new mUser();
            user.setCreateAt(dt);
            user.setPassword("admin");
            user.setPostOffice(post.getId());
            user.setUsername("admin@up.pl");
            userService.addUser(user);
        }
    }


}