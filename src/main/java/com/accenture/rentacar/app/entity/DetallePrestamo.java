package com.accenture.rentacar.app.entity;

import java.io.Serializable;
import java.time.DateTimeException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.accenture.rentacar.app.util.UtilDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name="detalle_prestamo")
public class DetallePrestamo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name= "vehiculo_id")
	@JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})
	private Vehiculo vehiculo;
	
	@Temporal (TemporalType.DATE)
	@Column (name="fecha_inicio_prestamo")
	private Date fechaInicioPrestamo;
	
	
	@Temporal (TemporalType.DATE)
	@Column (name="fecha_fin_prestamo")
	private Date fechaFinPrestamo;
	
	@Column(name= "total_dias_prestamo")
	private int totalDiasPrestamo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getFechaInicioPrestamo() {
		return fechaInicioPrestamo;
	}

	public void setFechaInicioPrestamo(Date fechaInicioPrestamo) {
		this.fechaInicioPrestamo = fechaInicioPrestamo;
	}

	public Date getFechaFinPrestamo() {
		return fechaFinPrestamo;
	}

	public void setFechaFinPrestamo(Date fechaFinPrestamo) {
		this.fechaFinPrestamo = fechaFinPrestamo;
	}

	public int getTotalDiasPrestamo() {
		return totalDiasPrestamo;
	}

	public void setTotalDiasPrestamo(int totalDiasPrestamo) {
		this.totalDiasPrestamo = totalDiasPrestamo;
	}
	
	@PrePersist
	public void calcularDias() throws DateTimeException {
		UtilDate.calcularDias(fechaInicioPrestamo, fechaFinPrestamo);
	}
}
