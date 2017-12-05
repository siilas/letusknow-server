package com.github.siilas.letusknow.dao;

import org.springframework.data.repository.CrudRepository;

import com.github.siilas.letusknow.model.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {

    Usuario findByUsuario(String usuario);

}
