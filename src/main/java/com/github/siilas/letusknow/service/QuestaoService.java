package com.github.siilas.letusknow.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.siilas.letusknow.dao.QuestaoDao;
import com.github.siilas.letusknow.dao.RespostaDao;
import com.github.siilas.letusknow.model.Questao;
import com.github.siilas.letusknow.model.Resposta;

@Component
public class QuestaoService {

    @Autowired
    private QuestaoDao questaoDao;

    @Autowired
    private RespostaDao respostaDao;

    public void criarSeNaoExistir(String descricao, List<String> respostas) {
        Questao questao = questaoDao.findByDescricao(descricao);
        if (questao == null) {
            questao = new Questao();
            questao.setDescricao(descricao);
            if (CollectionUtils.isNotEmpty(respostas)) {
                for (String resposta : respostas) {
                    Resposta model = respostaDao.findByDescricao(resposta);
                    if (model == null) {
                        model = new Resposta();
                        model.setDescricao(resposta);
                        model.setQuestao(questao);
                        model.setVotos(0L);
                        questao.getRespostas().add(model);
                        // respostaDao.save(model);
                    }
                }
            }
            questaoDao.save(questao);
        }
    }

}
