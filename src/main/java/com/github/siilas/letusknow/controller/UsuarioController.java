package com.github.siilas.letusknow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.siilas.letusknow.dao.UsuarioDao;
import com.github.siilas.letusknow.model.Usuario;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("usuarios", usuarioDao.findAll());
        return "usuario/index";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/form";
    }

    @GetMapping("/editar")
    public String editar(Model model, Long id) {
        model.addAttribute("usuario", usuarioDao.findOne(id));
        return "usuario/form";
    }

    @GetMapping("/excluir")
    public String excluir(Model model, Long id) {
        usuarioDao.delete(id);
        model.addAttribute("message", "Usuário removido com sucesso!");
        return "redirect:/usuario";
    }

    @PostMapping("/salvar")
    public String salvar(Model model, Usuario usuario) {
        try {
            if (usuario.getId() == null) {
                usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            }
            usuarioDao.save(usuario);
            model.addAttribute("message", "Usuário adicionado com sucesso!");
            return "redirect:/usuario";
        } catch (Exception e) {
            log.error("Erro ao adicionar usuário", e);
            model.addAttribute("message", "Erro ao adicionar usuário!");
            return "usuario/form";
        }
    }

}
