package com.testremember.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    /**
     * @return Страница для пользователей. Роль "USER"
     */
    @GetMapping(value = "/user")
    public String user () {
        return "/user";
    }

}
