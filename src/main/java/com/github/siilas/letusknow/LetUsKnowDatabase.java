package com.github.siilas.letusknow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.siilas.letusknow.dao.QuestaoDao;
import com.github.siilas.letusknow.service.QuestaoService;
import com.github.siilas.letusknow.service.UsuarioService;

@Configuration
public class LetUsKnowDatabase {

    @Autowired
    private QuestaoService questaoService;

    @Autowired
    private UsuarioService usuarioService;

    @Bean
    public CommandLineRunner criarUsuarioDefault() {
        return (args) -> {
            usuarioService.criarSeNaoExistir("admin", "123");
        };
    }

    @Bean
    public CommandLineRunner criarQuestoesDefault(QuestaoDao questaoDao) {
        return (args) -> {
            System.out.println("\n\n\nTeste 2\n\n\n");
        };
    }

}
