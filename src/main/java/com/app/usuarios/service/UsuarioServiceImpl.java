package com.app.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.usuarios.entity.UserRepository;
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
		Usuario currentPerson = usuarioDao.findByLogin(usuario.getLogin());
			
		currentPerson.setNombre(usuario.getNombre());
		currentPerson.setNombre(usuario.getNombre());
		currentPerson.setEmail(usuario.getEmail());
		currentPerson.setApellido_paterno(usuario.getApellido_paterno());
		currentPerson.setApellido_materno(usuario.getApellido_materno());
		currentPerson.setFechamodificacion(usuario.getFechamodificacion());
		
		Usuario res = usuarioDao.save(usuario);
		return res;
	}

	@Override
	public Usuario findByLogin(String login) {
		return usuarioDao.findByLogin(login);
	}
	

	@Override
	public Usuario delete(Usuario usuario) {
		Usuario currentPerson = usuarioDao.findByLogin(usuario.getLogin());
		
		
		currentPerson.setStatus('B');
		
		Usuario res = usuarioDao.save(usuario);
		return res;
		
	}
}
