package com.github.siilas.letusknow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questao")
public class QuestaoController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/novo")
    public String novo() {
        return "index";
    }

    @PostMapping("/salvar")
    public String salvar() {
        return "index";
    }

}
