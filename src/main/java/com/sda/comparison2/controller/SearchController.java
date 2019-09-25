package com.sda.comparison2.controller;

import com.sda.comparison2.entity.Product;
import com.sda.comparison2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private ProductService productService;

    // creat a controller for the search function
    @GetMapping
    public String viewSearchPage(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("model", model);
        return "search/search";
    }


    @GetMapping("/list")
    public String findAll(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("product", new Product());
        return "search/list";
    }

}
