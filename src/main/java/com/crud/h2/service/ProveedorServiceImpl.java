package com.crud.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.h2.dao.IProveedorDAO;
import com.crud.h2.dto.Proveedor;

@Service
public class ProveedorServiceImpl implements IProveedorService {

	@Autowired
	IProveedorDAO iProveedorDAO;
	
	@Override
	public List<Proveedor> listarProveedores() {
		
		return iProveedorDAO.findAll();
	}

	@Override
	public Proveedor guardarProveedor(Proveedor proveedor) {
		
		return iProveedorDAO.save(proveedor);
	}

	@Override
	public Proveedor proveedorXID(int codigo_proveedor) {
		
		return iProveedorDAO.findById(codigo_proveedor).get();
	}
	

	@Override
	public Proveedor actualizarProveedor(Proveedor proveedor) {
		
		return iProveedorDAO.save(proveedor);
	}

	@Override
	public void eliminarProveedor(int codigo_proveedor) {
		
		iProveedorDAO.deleteById(codigo_proveedor);
		
	}

}
