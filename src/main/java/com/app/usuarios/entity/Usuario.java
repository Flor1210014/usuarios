package com.app.usuarios.entity;

import java.sql.Date;
import java.util.Collection;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.AssertFalse.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios", uniqueConstraints = {@UniqueConstraint(columnNames = {"login"})})
public class Usuario implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "login",  nullable = false, length = 20)
	private String login;
	
	@Column(name = "username",  nullable = false, length = 20)
	private String username;
	
	@Column(name = "password", nullable = false, length = 30)
	private String password;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "client", nullable = false) 
	private float client;
	
	@Column(name = "email", length = 50) 
	private String email;
	
	@Column(name="fechaalta", nullable = false)
	@CreatedDate
	private Date fechaalta;
	
	private Date fechabaja;
	
	@Column(name="status", length = 1)
	@ColumnDefault("'A'")
	private char status;
	
	@Column(name="intentos")
	@ColumnDefault("0")
	private float intentos;
	
	@Column(name="fecharevocado")
	private Date fecharevocado;
	
	private Date fecha_vigencia;
	
	private int no_acceso;
	
	@Column(name = "apellido_paterno", length = 50)
	private String apellido_paterno;
	
	@Column(name = "apellido_materno", length = 50)
	private String apellido_materno;
	
	private int area;
	
	@Column(name="fechamodificacion")
	private Date fechamodificacion;
	
	@Enumerated(EnumType.STRING) 
    Role role;
	
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return List.of(new SimpleGrantedAuthority((role.name())));
    }
    @Override
    public boolean isAccountNonExpired() {
       return true;
    }
    @Override
    public boolean isAccountNonLocked() {
       return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
	
}
