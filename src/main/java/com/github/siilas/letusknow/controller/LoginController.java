package com.github.siilas.letusknow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.github.siilas.letusknow.model.Usuario;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public RedirectView login(@ModelAttribute Usuario usuario) {
        return new RedirectView("/", true);
    }

    @GetMapping("/logout")
    public RedirectView logout() {
        return new RedirectView("/login", true);
    }

}
