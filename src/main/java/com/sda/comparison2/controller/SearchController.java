package com.sda.comparison2.controller;

import com.sda.comparison2.entity.Product;
import com.sda.comparison2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String viewSearchPage(){
        return "search/search";
    }

    @PostMapping
    public String searchProduct(@ModelAttribute Product product, Model model) {
       List<Product> products =productService.listProducts();
        model.addAttribute("product", products);
        return "search/list";
    }


}
