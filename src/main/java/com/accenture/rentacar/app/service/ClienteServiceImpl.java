package com.accenture.rentacar.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.rentacar.app.dao.IClienteDao;
import com.accenture.rentacar.app.entity.Cliente;
import com.accenture.rentacar.app.entity.Vehiculo;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	
	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	public Cliente guardar(Cliente cliente) {
		
		return clienteDao.save(cliente);
	}
	
	@Override
	public void borrar(Long id) {
		clienteDao.deleteById(id);
		

	}
	
	@Override
	public Cliente buscarClientePorId (Long id) {
		
		return clienteDao.findById(id).orElse(null);
	}


	@Override
	public List<Cliente> listarTodos() {
		
		return (List<Cliente>) clienteDao.findAll();
	}

}
