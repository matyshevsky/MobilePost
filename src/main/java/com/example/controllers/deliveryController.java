package com.example.controllers;

import com.example.model.mDelivery;
import com.example.model.mTypes;
import com.example.service.DeliveryService;
import com.example.service.ProductService;
import com.example.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

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
        mTypes types = typesService.getTypesByCode("Paczka");
        if(types != null){
            Long delvierType = types.getId();
            model.addAttribute("products", productService.getProductByType(delvierType));
        }
        else{
            model.addAttribute("products", productService.getAllProducts());
        }

        return "addDeliver";
    }

    @RequestMapping(value = "/addDeliverTODO", method = RequestMethod.POST)
    public String addDeliver(@ModelAttribute(value="delivery") mDelivery delivery){
        delivery = deliveryService.makeDeliver(delivery);
        if(!delivery.getCode().isEmpty())
            return "confirmDeliver";
        else
            return "listDelivery";
    }

    @RequestMapping(value = "/addDeliver", method = RequestMethod.POST)
    public String confirmDeliver(@ModelAttribute(value="delivery") mDelivery delivery){
        delivery = deliveryService.makeDeliver(delivery);
        if(!delivery.getCode().isEmpty()){
            deliveryService.addDelivery(delivery);
            return "redirect:/delivery/list";
        }
        else{
            return "redirect:/delivery/list";
        }

    }

    @RequestMapping(value = "/advise", method = RequestMethod.GET)
    public String advise(@ModelAttribute(value="id") Long id){
        deliveryService.advise(id);
        return "redirect:/delivery/list";
    }

    @RequestMapping(value = "/delivered", method = RequestMethod.GET)
    public String delivered(@ModelAttribute(value="id") Long id){
        deliveryService.delivered(id);
        return "redirect:/delivery/list";
    }

    @RequestMapping(value= "/details", method = RequestMethod.GET)
    public String details(@ModelAttribute(value="id") Long id, Model model){
        model.addAttribute("delivery", deliveryService.getDeliveryById(id));
        return "detailsDelivery";
    }

}
