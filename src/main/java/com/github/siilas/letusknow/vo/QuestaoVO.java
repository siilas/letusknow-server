package com.github.siilas.letusknow.vo;

import java.util.Collections;
import java.util.List;

import com.github.siilas.letusknow.model.Questao;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.var;

@Getter
@Setter
public class QuestaoVO {

    private Long id;
    private String descricao;
    private List<RespostaVO> respostas;

    public List<RespostaVO> getRespostas() {
        if (respostas == null) {
            respostas = Collections.emptyList();
        }
        return respostas;
    }

    public Questao toModel() {
        var questao = new Questao();
        questao.setId(getId());
        questao.setDescricao(getDescricao());
        for (var reposta : getRespostas()) {
            questao.getRespostas().add(reposta.toModel(getId()));
        }
        return questao;
    }

}
