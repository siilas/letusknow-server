package com.github.siilas.letusknow.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.siilas.letusknow.service.QuestaoService;
import com.github.siilas.letusknow.vo.QuestaoVO;
import com.github.siilas.letusknow.vo.ResponseVO;
import com.github.siilas.letusknow.vo.VotosVO;

@RestController
@RequestMapping("/ws/questao")
public class QuestaoResource {

    @Autowired
    private QuestaoService questaoService;

    @GetMapping("/buscar")
    public List<QuestaoVO> buscar() {
        return questaoService.buscarTodos();
    }

    @PostMapping("/salvar")
    public ResponseVO salvar(@RequestBody VotosVO votos) {
        questaoService.salvar(votos);
        ResponseVO response = new ResponseVO();
        response.setSucesso(true);
        response.setMensagem("Questões salvas com sucesso!");
        return response;
    }

}
