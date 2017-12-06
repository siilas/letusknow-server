package com.github.siilas.letusknow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.github.siilas.letusknow.dao.UsuarioDao;
import com.github.siilas.letusknow.model.Usuario;

@Component
public class UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void criarSeNaoExistir(String username, String senha) {
        Usuario usuario = usuarioDao.findByNome(username);
        if (usuario == null) {
            usuario = new Usuario();
            usuario.setNome(username);
            usuario.setSenha(passwordEncoder.encode(senha));
            usuarioDao.save(usuario);
        }
    }

}
