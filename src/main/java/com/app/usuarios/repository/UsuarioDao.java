package com.app.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.usuarios.entity.Usuario;


@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long>{
	
	@Query("select u from Usuario u where u.login = ?1")
    public Usuario findByLogin(String login);
}
