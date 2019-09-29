package com.sda.comparison2.controller;

import com.sda.comparison2.entity.Product;
import com.sda.comparison2.scraper.AltexScraper;
import com.sda.comparison2.scraper.EmagScraper;
import com.sda.comparison2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/")
public class SearchController {

    @Autowired
    private ProductService productService;

    @Autowired
    private EmagScraper emagScraper;
    @Autowired
    private AltexScraper altexScraper;


    @GetMapping
    public String viewSearchPage(Model model) {
        return "search/search";
    }

    @PostMapping("/search")
    public String showSearchResults(Model model, @RequestParam String productName) {
        emagScraper.search(productName);
        altexScraper.altexSearch(productName);

        List<Product> productList = productService.findByName(productName);
        model.addAttribute("productList", productList);

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
