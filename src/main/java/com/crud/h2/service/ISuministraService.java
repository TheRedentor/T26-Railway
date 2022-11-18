package com.crud.h2.service;

import java.util.List;

import com.crud.h2.dto.Suministra;

public interface ISuministraService {
	
	public List<Suministra> listarSuministra();
	
	public Suministra guardarSuministra(Suministra suministra);
	
	public Suministra suministraXID(int codigo_suministra);
	
	public Suministra actualizarSuministra(Suministra suministra);
	
	public void eliminarSuministra(int codigo_suministra);
	
}
