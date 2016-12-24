package com.example.controllers;


import com.example.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.mProduct;
import com.example.service.ProductService;

import java.util.Collection;

/**
 * Created by Karol on 23.12.2016.
 */
@Controller
@RequestMapping(value = "/products")
public class productController {

    @Autowired
    ProductService productService;
    @Autowired
    TypesService typesService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllProduct(Model model){
        model.addAttribute("productList", productService.getAllProducts());
        return "listProduct";
    }
    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String addProduct(Model model){
        mProduct product = new mProduct();
        model.addAttribute("product", product);
        model.addAttribute("types", typesService.getAllTypes());
        return "addProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute(value="product") mProduct product){
        Collection<mProduct> products = productService.getAllProducts();
        for (mProduct item: products ) {
            if(item.getWeight() == product.getWeight() && item.getType() == product.getType()){
                return "redirect:/products/list";
            }
        }
        productService.addProduct(product);
        return "redirect:/products/list";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("types", typesService.getAllTypes());
        return "editProduct";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String update(@ModelAttribute("product") mProduct product) {
        productService.update(product);
        return "redirect:list";
    }

    @RequestMapping("/delete")
    public String remove(@RequestParam(value = "id") Long id) {
        productService.delete(id);
        return "redirect:list";
    }


}
