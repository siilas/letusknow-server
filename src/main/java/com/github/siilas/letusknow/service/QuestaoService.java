package com.github.siilas.letusknow.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.siilas.letusknow.dao.QuestaoDao;
import com.github.siilas.letusknow.dao.RespostaDao;
import com.github.siilas.letusknow.model.Questao;
import com.github.siilas.letusknow.model.Resposta;
import com.github.siilas.letusknow.vo.QuestaoVO;
import com.github.siilas.letusknow.vo.VotoVO;
import com.github.siilas.letusknow.vo.VotosVO;

import lombok.val;

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
            questao = questaoDao.save(questao);
            if (CollectionUtils.isNotEmpty(respostas)) {
                for (val resposta : respostas) {
                    Resposta model = respostaDao.findByDescricao(resposta);
                    if (model == null) {
                        model = new Resposta();
                        model.setDescricao(resposta);
                        model.setQuestao(questao);
                        model.setVotos(NumberUtils.LONG_ZERO);
                        model.setQuestaoId(questao.getId());
                        respostaDao.save(model);
                    }
                }
            }
        }
    }

    public List<QuestaoVO> buscarTodos() {
        List<QuestaoVO> response = new ArrayList<>();
        questaoDao.findAll().forEach(q -> response.add(q.toVO()));
        return response;
    }
    
    public Questao buscarPorId(Long id) {
        return questaoDao.findOne(id);
    }

    @Transactional
    public void salvar(VotosVO votos) {
        for (VotoVO voto : votos.getVotos()) {
            val questao = questaoDao.findOne(voto.getIdQuestao());
            if (questao != null) {
                for (val resposta : questao.getRespostas()) {
                    if (resposta.getId().equals(voto.getIdResposta())) {
                        resposta.contabilizarVoto();
                        respostaDao.save(resposta);
                        break;
                    }
                }
            }
        }
    }

    public void deletar(Questao questao) {
        questaoDao.delete(questao);
    }

    public Questao atualizar(Questao questao, Questao existente) {
        BeanUtils.copyProperties(questao, existente, "id");
        return questaoDao.save(questao);
    }

}
