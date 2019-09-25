package com.sda.comparison2.controller;

import com.sda.comparison2.entity.User;
import com.sda.comparison2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/list")
    public String getAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        return "user/list";
    }

    @PostMapping("/create")
    public String createUser (@ModelAttribute User user)  {
        userService.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id,Model model){
        User u = userService.findById(id);
        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        model.addAttribute("user", u);
        return "user/list";
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/user/list";
    }

}

