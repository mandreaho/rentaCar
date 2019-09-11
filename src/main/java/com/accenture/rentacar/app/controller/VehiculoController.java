package com.accenture.rentacar.app.controller;

import java.awt.Color;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.rentacar.app.entity.Vehiculo;
import com.accenture.rentacar.app.service.IVehiculoService;

@Controller
@RestController
@RequestMapping("/api")

public class VehiculoController {
	

	@Autowired
	private IVehiculoService  vehiculoService;
	
	@GetMapping("/vehiculos")	
	public List<Vehiculo> listar(){
		
		return vehiculoService.listarTodos();
	
	}
		
	@GetMapping("/vehiculos/(id)")	
	public Vehiculo buscarPoId( @PathVariable Long id) {
		return vehiculoService.buscarVehiculoPorId(id);
		
		
	}
	
	@PostMapping("/vehiculos")
	public Vehiculo guardar (@RequestBody Vehiculo vehiculo) {
		
		return vehiculoService.guardar(vehiculo);
		
	}
	
	
	@PostMapping("/actualizar")
	public Vehiculo actualizar (@RequestBody Vehiculo vehiculo) {
		
		Vehiculo vehAActualizar = new Vehiculo();
		Vehiculo vehActual = vehiculoService.buscarVehiculoPorId(vehiculo.getId());
		vehAActualizar.setId(vehiculo.getId() );
		vehAActualizar.setColor(vehiculo.getColor());
		vehAActualizar.setLinea(vehiculo.getLinea() );
		vehAActualizar.setMarca(vehiculo.getMarca());
		vehAActualizar.setModelo(vehiculo.getModelo() );
		vehAActualizar.setPlaca(vehiculo.getPlaca());
		
		
		return vehiculoService.guardar(vehAActualizar);
	}
	
	public void borrar () {
		
	}
	
	
}

