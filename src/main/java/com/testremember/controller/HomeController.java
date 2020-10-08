package com.testremember.controller;

import com.testremember.model.User;
import com.testremember.repository.Repositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {


    private final
    Repositories repositories;

    public HomeController(Repositories repositories) {
        this.repositories = repositories;
    }



    /////////////////////
    @GetMapping(value = "/")
    public String  home () {
            return "/home";
    }


    /////////////////////
    @GetMapping(value = "/admin")
    public String admin () {
        return "/admin";
    }


    /////////////////////
    @GetMapping(value = "/user")
    public String user () {
        return "/user";
    }


    /////////////////////
    @GetMapping(value = "/login")
    public String loginGet () {
        return "/login";
    }

    @PostMapping(value = "/login")
    public String loginPost () {
        return "redirect:/home";
    }


    /////////////////////
    @GetMapping(value = "/registration")
    public String registration (Model model) {
        model.addAttribute("user", new User());
        return "/registration";
    }


    @PostMapping("/registration")
    public String registrationUser(@ModelAttribute("user") User user){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        repositories.createUser(user);
        return "redirect:/login";

    }

}
