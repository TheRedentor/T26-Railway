package com.crud.h2.service;

import java.util.List;

import com.crud.h2.dto.Proveedor;

public interface IProveedorService {
	
	public List<Proveedor> listarProveedores();
	
	public Proveedor guardarProveedor(Proveedor proveedor);
	
	public Proveedor proveedorXID(int codigo_proveedor);
	
	public Proveedor actualizarProveedor(Proveedor proveedor);
	
	public void eliminarProveedor(int codigo_proveedor);
	
}
