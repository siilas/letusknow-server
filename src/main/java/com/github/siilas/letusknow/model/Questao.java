package com.github.siilas.letusknow.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.github.siilas.letusknow.vo.QuestaoVO;

import lombok.Data;
import lombok.experimental.var;

@Data
@Entity
@Table(name = "QUESTAO")
public class Questao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "questao", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Resposta> respostas;

    public List<Resposta> getRespostas() {
        if (respostas == null) {
            respostas = Collections.emptyList();
        }
        return respostas;
    }

    public QuestaoVO toVO() {
        var questao = new QuestaoVO();
        questao.setId(getId());
        questao.setDescricao(getDescricao());
        for (var resposta : getRespostas()) {
            questao.getRespostas().add(resposta.toVO());
        }
        return questao;
    }

}
