package com.app.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.usuarios.entity.Usuario;
import com.app.usuarios.repository.UsuarioDao;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
	private UsuarioDao usuarioDao;
	
	

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
}
