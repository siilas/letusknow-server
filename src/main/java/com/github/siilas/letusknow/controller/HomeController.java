package com.github.siilas.letusknow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.siilas.letusknow.service.QuestaoService;
import com.github.siilas.letusknow.vo.QuestaoVO;

@Controller
public class HomeController {

    @Autowired
    private QuestaoService questaoService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @ResponseBody
    @GetMapping("/buscar-questoes")
    public List<QuestaoVO> buscarQuestoes() {
        return questaoService.buscarTodos();
    }

}
