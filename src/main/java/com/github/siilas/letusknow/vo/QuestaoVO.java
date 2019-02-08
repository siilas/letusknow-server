package com.github.siilas.letusknow.vo;

import java.util.ArrayList;
import java.util.List;

import com.github.siilas.letusknow.model.Questao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestaoVO {

    private Long id;
    private String descricao;
    private List<RespostaVO> respostas;

    public List<RespostaVO> getRespostas() {
        if (respostas == null) {
            respostas = new ArrayList<>();
        }
        return respostas;
    }

    public Questao toModel() {
        Questao questao = new Questao();
        questao.setId(getId());
        questao.setDescricao(getDescricao());
        for (RespostaVO reposta : getRespostas()) {
            questao.getRespostas().add(reposta.toModel(getId()));
        }
        return questao;
    }

}
