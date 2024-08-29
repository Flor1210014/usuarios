package com.app.usuarios.auth;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import com.app.usuarios.entity.Role;
import com.app.usuarios.entity.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
	
	String login;
	String username;
	String password;
	String nombre;
	float client;
	String email;
	Date fechaalta;
	Date fechabaja;
	char status;
	float intentos;
	Date fecharevocado;
	Date fecha_vigencia;
	int no_acceso;
	String apellido_paterno;
	String apellido_materno;
	int area;
	Date fechamodificacion;
    Role role;
	
    
}
