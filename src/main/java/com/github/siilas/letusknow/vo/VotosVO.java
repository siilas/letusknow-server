package com.github.siilas.letusknow.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotosVO {

    private List<VotoVO> votos;

    public List<VotoVO> getVotos() {
        if (votos == null) {
            votos = new ArrayList<>();
        }
        return votos;
    }

}
