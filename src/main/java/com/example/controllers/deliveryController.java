package com.example.controllers;

import com.example.model.mDelivery;
import com.example.service.DeliveryService;
import com.example.service.ProductService;
import com.example.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Karol on 24.12.2016.
 */
@Controller
@RequestMapping(value = "/delivery")
public class deliveryController {

    @Autowired
    DeliveryService deliveryService;
    @Autowired
    ProductService productService;
    @Autowired
    TypesService typesService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllDelivers(Model model){
        model.addAttribute("deliverList", deliveryService.getAllDelivers());
        return "listDelivery";
    }

    @RequestMapping(value = "/addDeliver", method = RequestMethod.GET)
    public String addDeliver(Model model){
        mDelivery mDelivery = new mDelivery();
        model.addAttribute("delivery", mDelivery);
        Long delvierType = typesService.getTypesByCode("Paczka").getId();
        model.addAttribute("products", productService.getProductByType(delvierType));
        return "addDeliver";
    }

    @RequestMapping(value = "/addDeliverTODO", method = RequestMethod.POST)
    public String addDeliver(@ModelAttribute(value="delivery") mDelivery delivery){
        delivery = deliveryService.makeDeliver(delivery);
        return "confirmDeliver";
    }

    @RequestMapping(value = "/addDeliver", method = RequestMethod.POST)
    public String confirmDeliver(@ModelAttribute(value="delivery") mDelivery delivery){
        delivery = deliveryService.makeDeliver(delivery);
        deliveryService.addDelivery(delivery);
        return "redirect:/delivery/list";
    }



}
