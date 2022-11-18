package com.crud.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.h2.dto.Proveedor;

public interface IProveedorDAO extends JpaRepository<Proveedor, Integer> {
	
}