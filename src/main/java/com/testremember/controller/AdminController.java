package com.testremember.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


    @GetMapping(value = "/admin")
    public String admin () {
        return "/admin";
    }

}
