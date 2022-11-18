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

import com.crud.h2.dto.Suministra;
import com.crud.h2.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api")
public class SuministraController {
	@Autowired
	SuministraServiceImpl suministraServiceImpl;
	
	@GetMapping("/suministra")
	public List<Suministra> listarSuministra(){
		return suministraServiceImpl.listarSuministra();
	}
	
	
	@PostMapping("/suministra")
	public Suministra salvarSuministra(@RequestBody Suministra suministra) {
		
		return suministraServiceImpl.guardarSuministra(suministra);
	}
	
	
	@GetMapping("/suministra/{codigo_suministra}")
	public Suministra suministraXID(@PathVariable(name="codigo_suministra") int codigo_suministra) {
		
		Suministra suministra_xid= new Suministra();
		
		suministra_xid=suministraServiceImpl.suministraXID(codigo_suministra);
		
		System.out.println("Suministra XID: "+suministra_xid);
		
		return suministra_xid;
	}
	
	@PutMapping("/suministra/{codigo_suministra}")
	public Suministra actualizarSuministra(@PathVariable(name="codigo_suministra")int codigo_suministra,@RequestBody Suministra suministra) {
		
		Suministra suministra_seleccionado= new Suministra();
		Suministra suministra_actualizado= new Suministra();
		
		suministra_seleccionado= suministraServiceImpl.suministraXID(codigo_suministra);
		
		suministra_seleccionado.setPieza(suministra.getPieza());
		suministra_seleccionado.setProveedor(suministra.getProveedor());
		suministra_seleccionado.setPrecio(suministra.getPrecio());
		
		suministra_actualizado = suministraServiceImpl.actualizarSuministra(suministra_seleccionado);
		
		System.out.println("El suministro actualizado es: "+ suministra_actualizado);
		
		return suministra_actualizado;
	}
	
	@DeleteMapping("/suministra/{codigo_suministra}")
	public void eliminarSuministra(@PathVariable(name="codigo_suministra")int codigo_suministra) {
		suministraServiceImpl.eliminarSuministra(codigo_suministra);
	}
}
