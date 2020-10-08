package com.testremember.controller;


import com.testremember.model.User;
import com.testremember.repository.Repositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {


    private final
    Repositories repositories;

    public RegistrationController(Repositories repositories) {
        this.repositories = repositories;
    }






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




