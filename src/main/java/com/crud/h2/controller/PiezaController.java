package com.crud.h2.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.h2.dto.Pieza;
import com.crud.h2.service.PiezaServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezaController {
	@Autowired
	PiezaServiceImpl piezaServiceImpl;
	
	@GetMapping("/piezas")
	public List<Pieza> listarPiezas(){
		return piezaServiceImpl.listarPiezas();
	}
	
	
	@PostMapping("/piezas")
	public Pieza salvarPieza(@RequestBody Pieza pieza) {
		
		return piezaServiceImpl.guardarPieza(pieza);
	}
	
	
	@GetMapping("/piezas/{codigo_pieza}")
	public Pieza piezaXID(@PathVariable(name="codigo_pieza") int codigo_pieza) {
		
		Pieza pieza_xid= new Pieza();
		
		pieza_xid=piezaServiceImpl.piezaXID(codigo_pieza);
		
		System.out.println("Pieza XID: "+pieza_xid);
		
		return pieza_xid;
	}
	
	@PutMapping("/piezas/{codigo_pieza}")
	public Pieza actualizarPieza(@PathVariable(name="codigo_pieza")int codigo_pieza,@RequestBody Pieza pieza) {
		
		Pieza pieza_seleccionado= new Pieza();
		Pieza pieza_actualizado= new Pieza();
		
		pieza_seleccionado= piezaServiceImpl.piezaXID(codigo_pieza);
		
		pieza_seleccionado.setNombre(pieza.getNombre());
		
		pieza_actualizado = piezaServiceImpl.actualizarPieza(pieza_seleccionado);
		
		System.out.println("La pieza actualizada es: "+ pieza_actualizado);
		
		return pieza_actualizado;
	}
	
	@DeleteMapping("/piezas/{codigo_pieza}")
	public void eliminarPieza(@PathVariable(name="codigo_pieza")int codigo_pieza) {
		piezaServiceImpl.eliminarPieza(codigo_pieza);
	}
}
