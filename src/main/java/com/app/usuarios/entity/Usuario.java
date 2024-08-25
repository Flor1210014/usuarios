package com.app.usuarios.entity;

import java.sql.Date;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "login",  nullable = false, length = 20)
	private String login;
	
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
	
	@Column(name="fechabaja")
	private Date fechabaja;
	
	@Column(name="status", length = 1)
	@ColumnDefault("'A'")
	private char status;
	
	@Column(name="intentos")
	@ColumnDefault("0")
	private float intentos;
	
	@Column(name="fecharevocado")
	private Date fecharevocado;
	
	@Column(name="fecha_vigencia")
	private Date fecha_vigencia;
	
	@Column(name="no_acceso")
	private int no_acceso;
	
	@Column(name = "apellido_paterno", length = 50)
	private String apellido_paterno;
	
	@Column(name = "apellido_materno", length = 50)
	private String apellido_materno;
	
	@Column(name="area")
	private int area;
	
	@Column(name="fechamodificacion")
	private Date fechamodificacion;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getClient() {
		return client;
	}

	public void setClient(float client) {
		this.client = client;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaalta() {
		return fechaalta;
	}

	public void setFechaalta(Date fechaalta) {
		this.fechaalta = fechaalta;
	}

	public Date getFechabaja() {
		return fechabaja;
	}

	public void setFechabaja(Date fechabaja) {
		this.fechabaja = fechabaja;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public float getIntentos() {
		return intentos;
	}

	public void setIntentos(float intentos) {
		this.intentos = intentos;
	}

	public Date getFecharevocado() {
		return fecharevocado;
	}

	public void setFecharevocado(Date fecharevocado) {
		this.fecharevocado = fecharevocado;
	}

	public Date getFecha_vigencia() {
		return fecha_vigencia;
	}

	public void setFecha_vigencia(Date fecha_vigencia) {
		this.fecha_vigencia = fecha_vigencia;
	}

	public int getNo_acceso() {
		return no_acceso;
	}

	public void setNo_acceso(int no_acceso) {
		this.no_acceso = no_acceso;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public Date getFechamodificacion() {
		return fechamodificacion;
	}

	public void setFechamodificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	
}
