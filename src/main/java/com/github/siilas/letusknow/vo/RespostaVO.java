package com.github.siilas.letusknow.vo;

import com.github.siilas.letusknow.model.Resposta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaVO {

    private Long id;
    private String descricao;
    private Long votos;

    public Long getVotos() {
        if (votos == null) {
            votos = 0L;
        }
        return votos;
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
