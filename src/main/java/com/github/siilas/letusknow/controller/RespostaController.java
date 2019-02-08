package com.github.siilas.letusknow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.siilas.letusknow.dao.RespostaDao;
import com.github.siilas.letusknow.vo.AjaxVO;

import lombok.experimental.var;

@Controller
@RequestMapping("/resposta")
public class RespostaController {

    @Autowired
    private RespostaDao respostaDao;

    @ResponseBody
    @GetMapping("/excluir")
    public AjaxVO excluir(Long id) {
        respostaDao.delete(id);
        var response = new AjaxVO();
        response.setMensagem("Resposta removida com sucesso!");
        return response;
    }

}
