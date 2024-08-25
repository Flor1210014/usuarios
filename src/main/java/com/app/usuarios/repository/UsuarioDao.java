package com.app.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.usuarios.entity.Usuario;


@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long>{

}
