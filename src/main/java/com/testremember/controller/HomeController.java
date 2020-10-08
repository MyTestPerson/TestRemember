package com.testremember.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {



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


}
