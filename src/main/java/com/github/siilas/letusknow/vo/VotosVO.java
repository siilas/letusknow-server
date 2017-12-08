package com.github.siilas.letusknow.vo;

import java.util.ArrayList;
import java.util.List;

public class VotosVO {

    private List<VotoVO> votos;

    public List<VotoVO> getVotos() {
        if (votos == null) {
            votos = new ArrayList<>();
        }
        return votos;
    }

    public void setVotos(List<VotoVO> votos) {
        this.votos = votos;
    }

}
