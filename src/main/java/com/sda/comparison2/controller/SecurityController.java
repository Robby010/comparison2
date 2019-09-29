package com.sda.comparison2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String loginPage() {
        return "/login/login";
    }



    @GetMapping
    public String logOut(){return "/search/search";}

    @GetMapping("/accessDenied")
    public String accessDenied()
    {
        return "accessDenied";
    }

    @GetMapping("/unsecured")
    public String unsecured() {
        return "unsecured";
    }

    @GetMapping("/securedAdmin")
    public String securedAdmin() {
        return "securedAdmin";
    }

    @GetMapping("/securedClient")
    public String securedClient() {
        return "securedClient";
    }

    @PostMapping
    public String createUser(){return "login/create";}
}
