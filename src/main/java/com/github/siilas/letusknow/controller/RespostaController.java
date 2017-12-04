package com.github.siilas.letusknow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resposta")
public class RespostaController {

    @RequestMapping
    public String index() {
        return "index";
    }

    @RequestMapping("/novo")
    public String novo() {
        return "index";
    }

    @RequestMapping("/salvar")
    public String salvar() {
        return "index";
    }

}
