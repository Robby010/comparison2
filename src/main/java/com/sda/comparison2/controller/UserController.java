package com.sda.comparison2.controller;

import com.sda.comparison2.entity.User;
import com.sda.comparison2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping("/list")
    public String getAll(Model model){
        List<User> users = userService.get();;
        return "user/list";
    }

    @RequestMapping
    public String createUser (Model model)  {
        model.addAttribute("user", new User());
        return "user/create";
    }

}

