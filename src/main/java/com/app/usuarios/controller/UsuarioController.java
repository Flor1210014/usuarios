package com.app.usuarios.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.usuarios.entity.Usuario;
import com.app.usuarios.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UsuarioController {
    @Autowired
	private UsuarioService usuarioService;
    
    @PostMapping(value = "demo")
    public String welcome()
    {
        return "Welcome from secure endpoint";
    }
    
    @GetMapping(value="/usuarios")
	public ResponseEntity<Object> get(){ 
		java.util.Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Usuario> list  = usuarioService.findAll();
			return new ResponseEntity<Object>(list,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}
    @PostMapping(value="/usuario/update")
	public ResponseEntity<Object> update(@RequestBody Usuario usuario){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Date fechaActual = new Date();
			Usuario currentPerson = usuarioService.findByLogin(usuario.getLogin());
			
			
			currentPerson.setNombre(usuario.getNombre());
			currentPerson.setEmail(usuario.getEmail());
			currentPerson.setApellido_paterno(usuario.getApellido_paterno());
			currentPerson.setApellido_materno(usuario.getApellido_materno());
			currentPerson.setFechamodificacion(fechaActual);
			
			Usuario res = usuarioService.update(currentPerson);
			
			return new ResponseEntity<Object>(res,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}
    
    @PostMapping(value="/usuario/baja")
   	public ResponseEntity<Object> baja(@RequestBody Usuario usuario){ 
   		Map<String, Object> map = new HashMap<String, Object>();
   		try {
   			
   			Usuario currentPerson = usuarioService.findByLogin(usuario.getLogin());
   			Usuario res = usuarioService.delete(currentPerson);
   			
   			return new ResponseEntity<Object>(res,HttpStatus.OK);
   		} 
   		catch (Exception e) {
   			map.put("message", e.getMessage());
   			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
   		} 
    	}
    
}