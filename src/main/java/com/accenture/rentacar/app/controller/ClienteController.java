package com.accenture.rentacar.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.rentacar.app.entity.Cliente;
import com.accenture.rentacar.app.service.IClienteService;



@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private IClienteService  clienteService;
	
	@GetMapping("/cliente")	
	public List<Cliente> listar(){
		
		return clienteService.listarTodos();
	
	}
		
	@GetMapping("/cliente/(id)")	
	public Cliente buscarPoId( @PathVariable Long id) {
		return clienteService.buscarClientePorId(id);
		
		
		
	}
	
	@PostMapping("/cliente")
	public Cliente guardar (@RequestBody Cliente cliente) {
		
		return clienteService.guardar(cliente);
		
	}
	
	
	@PostMapping("/actualizarCliente")
	public Cliente actualizar (@RequestBody Cliente cliente) {
		
		Cliente ClienteAActualizar = new Cliente();
		Cliente clienteActual = clienteService.buscarClientePorId(cliente.getId());
		ClienteAActualizar.setId(clienteActual.getId() );
		ClienteAActualizar.setCedula(clienteActual.getCedula());
		ClienteAActualizar.setNombre(clienteActual.getNombre() );
		ClienteAActualizar.setApellido(clienteActual.getApellido());
		ClienteAActualizar.setTelefono(clienteActual.getTelefono() );
		ClienteAActualizar.setDireccion(clienteActual.getDireccion());
		ClienteAActualizar.setEmail(clienteActual.getEmail());
		
		
		return clienteService.guardar(ClienteAActualizar);
	}
	
	public void borrar () {
		
	}

}
