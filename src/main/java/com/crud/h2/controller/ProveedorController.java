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

import com.crud.h2.dto.Proveedor;
import com.crud.h2.service.ProveedorServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedorController {
	@Autowired
	ProveedorServiceImpl proveedorServiceImpl;
	
	@GetMapping("/proveedores")
	public List<Proveedor> listarProveedores(){
		return proveedorServiceImpl.listarProveedores();
	}
	
	
	@PostMapping("/proveedores")
	public Proveedor salvarProveedor(@RequestBody Proveedor proveedor) {
		
		return proveedorServiceImpl.guardarProveedor(proveedor);
	}
	
	
	@GetMapping("/proveedores/{codigo_proveedor}")
	public Proveedor proveedorXID(@PathVariable(name="codigo_proveedor") int codigo_proveedor) {
		
		Proveedor proveedor_xid= new Proveedor();
		
		proveedor_xid=proveedorServiceImpl.proveedorXID(codigo_proveedor);
		
		System.out.println("Proveedor XID: "+proveedor_xid);
		
		return proveedor_xid;
	}
	
	@PutMapping("/proveedores/{codigo_proveedor}")
	public Proveedor actualizarProveedor(@PathVariable(name="codigo_proveedor")int codigo_proveedor,@RequestBody Proveedor proveedor) {
		
		Proveedor proveedor_seleccionado= new Proveedor();
		Proveedor proveedor_actualizado= new Proveedor();
		
		proveedor_seleccionado= proveedorServiceImpl.proveedorXID(codigo_proveedor);
		
		proveedor_seleccionado.setNombre(proveedor.getNombre());
		
		proveedor_actualizado = proveedorServiceImpl.actualizarProveedor(proveedor_seleccionado);
		
		System.out.println("El proveedor actualizado es: "+ proveedor_actualizado);
		
		return proveedor_actualizado;
	}
	
	@DeleteMapping("/proveedores/{codigo_proveedor}")
	public void eliminarProveedor(@PathVariable(name="codigo_proveedor")int codigo_proveedor) {
		proveedorServiceImpl.eliminarProveedor(codigo_proveedor);
	}
}
