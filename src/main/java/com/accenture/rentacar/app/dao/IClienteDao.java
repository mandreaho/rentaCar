package com.accenture.rentacar.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.accenture.rentacar.app.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
