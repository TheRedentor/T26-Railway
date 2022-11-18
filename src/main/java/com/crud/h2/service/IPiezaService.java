package com.crud.h2.service;

import java.util.List;

import com.crud.h2.dto.Pieza;

public interface IPiezaService {
	
	public List<Pieza> listarPiezas();
	
	public Pieza guardarPieza(Pieza pieza);
	
	public Pieza actualizarPieza(Pieza pieza);
	
	public void eliminarPieza(int codigo_pieza);

	public Pieza piezaXID(int codigo_pieza);
	
}
