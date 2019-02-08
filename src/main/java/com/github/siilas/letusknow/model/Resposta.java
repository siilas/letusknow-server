package com.github.siilas.letusknow.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.math.NumberUtils;

import com.github.siilas.letusknow.vo.RespostaVO;

import lombok.Data;
import lombok.experimental.var;

@Data
@Entity
@Table(name = "RESPOSTA")
public class Resposta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 60)
    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @NotNull
    @Column(name = "VOTOS", nullable = false)
    private Long votos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTAO", insertable = false, updatable = false)
    private Questao questao;

    @NotNull
    @Column(name = "QUESTAO")
    private Long questaoId;

    public Long getVotos() {
        if (votos == null) {
            votos = NumberUtils.LONG_ZERO;
        }
        return votos;
    }

    public RespostaVO toVO() {
        var resposta = new RespostaVO();
        resposta.setId(getId());
        resposta.setDescricao(getDescricao());
        resposta.setVotos(getVotos());
        return resposta;
    }

    public void contabilizarVoto() {
        setVotos(getVotos() + NumberUtils.LONG_ONE);
    }

}
