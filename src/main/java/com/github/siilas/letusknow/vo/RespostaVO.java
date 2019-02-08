package com.github.siilas.letusknow.vo;

import org.apache.commons.lang3.math.NumberUtils;

import com.github.siilas.letusknow.model.Resposta;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.var;

@Getter
@Setter
public class RespostaVO {

    private Long id;
    private String descricao;
    private Long votos;

    public Long getVotos() {
        if (votos == null) {
            votos = NumberUtils.LONG_ZERO;
        }
        return votos;
    }

    public Resposta toModel(Long questaoId) {
        var resposta = new Resposta();
        resposta.setId(getId());
        resposta.setDescricao(getDescricao());
        resposta.setVotos(getVotos());
        resposta.setQuestaoId(questaoId);
        return resposta;
    }

}
