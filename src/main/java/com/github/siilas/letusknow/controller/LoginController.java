package com.github.siilas.letusknow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(String error, Model model) {
        if (error != null) {
            model.addAttribute("message", "Usuário e/ou senha incorretos!");
        }
        return "login";
    }

}
