package com.github.siilas.letusknow.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.siilas.letusknow.dao.QuestaoDao;
import com.github.siilas.letusknow.model.Questao;

@Controller
@RequestMapping("/questao")
public class QuestaoController {

    private static final Logger LOGGER = Logger.getLogger(QuestaoController.class);

    @Autowired
    private QuestaoDao questaoDao;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("questoes", questaoDao.findAll());
        return "questao/index";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("questao", new Questao());
        return "questao/form";
    }

    @GetMapping("/editar")
    public String editar(Model model, Long id) {
        model.addAttribute("questao", questaoDao.findOne(id));
        return "questao/form";
    }

    @GetMapping("/excluir")
    public String excluir(Model model, Long id) {
        questaoDao.delete(id);
        model.addAttribute("message", "Questão removida com sucesso!");
        return "redirect:/questao";
    }

    @PostMapping("/salvar")
    public String salvar(Model model, Questao questao) {
        try {
            questaoDao.save(questao);
            model.addAttribute("message", "Questão adicionada com sucesso!");
            return "questao/index";
        } catch (Exception e) {
            LOGGER.error("Erro ao adicionar questão", e);
            model.addAttribute("message", "Erro ao adicionar questão!");
            return "questao/novo";
        }
    }

}
