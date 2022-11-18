package com.crud.h2.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crud.h2.dao.IPiezaDAO;
import com.crud.h2.dto.Pieza;

@Service
public class PiezaServiceImpl implements IPiezaService {
	@Autowired
	IPiezaDAO iPiezaDAO;
	
	@Override
	public List<Pieza> listarPiezas() {
		
		return iPiezaDAO.findAll();
	}

	@Override
	public Pieza guardarPieza(Pieza pieza) {
		
		return iPiezaDAO.save(pieza);
	}

	@Override
	public Pieza piezaXID(int codigo_pieza) {
		
		return iPiezaDAO.findById(codigo_pieza).get();
	}
	

	@Override
	public Pieza actualizarPieza(Pieza pieza) {
		
		return iPiezaDAO.save(pieza);
	}

	@Override
	public void eliminarPieza(int codigo_pieza) {
		
		iPiezaDAO.deleteById(codigo_pieza);
		
	}
}
