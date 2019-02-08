package com.github.siilas.letusknow.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.siilas.letusknow.model.Questao;
import com.github.siilas.letusknow.service.QuestaoService;
import com.github.siilas.letusknow.vo.QuestaoVO;
import com.github.siilas.letusknow.vo.ResponseVO;
import com.github.siilas.letusknow.vo.VotosVO;

@RestController
@RequestMapping("/ws/questoes")
public class QuestaoResource {

    @Autowired
    private QuestaoService questaoService;

    @GetMapping
    public List<QuestaoVO> buscar() {
        return questaoService.buscarTodos();
    }
    
    @GetMapping("{id}")
    public ResponseEntity<QuestaoVO> buscar(@PathVariable Long id) {
        Questao questao = questaoService.buscarPorId(id);
        if (questao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(questao.toVO());
    }

    @PostMapping
    public ResponseVO salvar(@Valid @RequestBody VotosVO votos) {
        questaoService.salvar(votos);
        ResponseVO response = new ResponseVO();
        response.setSucesso(true);
        response.setMensagem("Questões salvas com sucesso!");
        return response;
    }

    @PutMapping("{id}")
    public ResponseEntity<Questao> atualizar(@PathVariable Long id, @RequestBody Questao questao) {
        Questao existente = questaoService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        existente = questaoService.atualizar(questao, existente);
        return ResponseEntity.ok(existente);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Questao questao = questaoService.buscarPorId(id);
        if (questao == null) {
            return ResponseEntity.notFound().build();
        }
        questaoService.deletar(questao);
        return ResponseEntity.noContent().build();
    }

}
