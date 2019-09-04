package com.accenture.rentacar.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.accenture.rentacar.app.entity.Vehiculo;


public interface IVehiculoDao extends CrudRepository<Vehiculo, Long> {
	
	

}
