package com.github.siilas.letusknow.vo;

import com.github.siilas.letusknow.model.Resposta;

public class RespostaVO {

    private Long id;
    private String descricao;
    private Long votos;

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

    public Long getVotos() {
        if (votos == null) {
            votos = 0L;
        }
        return votos;
    }

    public void setVotos(Long votos) {
        this.votos = votos;
    }

    public Resposta toModel(Long questaoId) {
        Resposta resposta = new Resposta();
        resposta.setId(getId());
        resposta.setDescricao(getDescricao());
        resposta.setVotos(getVotos());
        resposta.setQuestaoId(questaoId);
        return resposta;
    }

}
