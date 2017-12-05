package com.github.siilas.letusknow;

import java.util.Arrays;

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
            questaoService.criarSeNaoExistir("No geral, como é a sua saúde?",
                    Arrays.asList("Boa", "Ruim"));
            questaoService.criarSeNaoExistir("Comparando com um ano atrás, como você diria que a sua saúde está hoje?",
                    Arrays.asList("Melhor", "Igual", "Pior"));
            questaoService.criarSeNaoExistir("Quanta dor no corpo você sentiu durante as últimas semanas?",
                    Arrays.asList("Muita", "Pouca"));
            questaoService.criarSeNaoExistir("Há limitação de atividades devido ao seu estado de saúde atual?",
                    Arrays.asList("Sim", "Não"));
            questaoService.criarSeNaoExistir("Qual a interferência da dor durante o seu dia-a-dia?",
                    Arrays.asList("Muita", "Pouca"));
        };
    }

}
