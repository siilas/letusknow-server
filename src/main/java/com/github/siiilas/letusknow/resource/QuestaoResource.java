package com.github.siiilas.letusknow.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ws/questao")
public class QuestaoResource {

    @GetMapping("/buscar")
    public String buscar() {
        return "Teste!";
    }

    @PostMapping("/salvar")
    public String salvar() {
        return "Teste!";
    }

}
