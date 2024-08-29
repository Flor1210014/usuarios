package com.app.usuarios.service;

import java.util.List;

import com.app.usuarios.entity.Usuario;



public interface UsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario save(Usuario usuario);
	
	public Usuario update(Usuario usuario);
	
	public Usuario findByLogin(String login);
	
	public Usuario delete(Usuario usuario);

}
