package com.github.siilas.letusknow.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.siilas.letusknow.dao.QuestaoDao;

@RestController
@RequestMapping("/ws/questao")
public class QuestaoResource {

    @Autowired
    private QuestaoDao questaoDao;

    @GetMapping("/buscar")
    public String buscar() {
        questaoDao.findAll();
        return "Teste!";
    }

    @PostMapping("/salvar")
    public String salvar() {
        return "Teste!";
    }

}
