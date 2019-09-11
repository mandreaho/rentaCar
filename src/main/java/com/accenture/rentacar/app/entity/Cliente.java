package com.accenture.rentacar.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String telefono;
	private String direccion;
	private String email;
	
	@Column(name="fecha_creacion_registro")
	@Temporal(TemporalType.DATE  )
	private Date fechaCreacionCliente;
	
	@PrePersist
	private void preGuardado() {
		fechaCreacionCliente = new Date(); 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaCreacionCliente() {
		return fechaCreacionCliente;
	}

	public void setFechaCreacionCliente(Date fechaCreacionCliente) {
		this.fechaCreacionCliente = fechaCreacionCliente;
	}
	
	
	
}
