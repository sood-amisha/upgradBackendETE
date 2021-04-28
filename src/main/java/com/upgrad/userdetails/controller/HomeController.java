package com.upgrad.userdetails.controller;

import com.upgrad.userdetails.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "home";
    }

}
