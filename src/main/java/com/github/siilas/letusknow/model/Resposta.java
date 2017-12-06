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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
        return votos;
    }

    public void setVotos(Long votos) {
        this.votos = votos;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Long getQuestaoId() {
        return questaoId;
    }

    public void setQuestaoId(Long questaoId) {
        this.questaoId = questaoId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Resposta) {
            Resposta other = (Resposta) obj;
            return new EqualsBuilder()
                    .append(id, other.id)
                    .append(descricao, other.descricao)
                    .append(votos, other.votos)
                    .append(questaoId, other.questaoId)
                    .isEquals();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(descricao)
                .append(votos)
                .append(questaoId)
                .toHashCode();
    }

}
