package com.github.siilas.letusknow.vo;

import java.util.ArrayList;
import java.util.List;

import com.github.siilas.letusknow.model.Questao;

public class QuestaoVO {

    private Long id;
    private String descricao;
    private List<RespostaVO> respostas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<RespostaVO> getRespostas() {
        if (respostas == null) {
            respostas = new ArrayList<>();
        }
        return respostas;
    }

    public void setRespostas(List<RespostaVO> respostas) {
        this.respostas = respostas;
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
