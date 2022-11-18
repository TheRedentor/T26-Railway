package com.crud.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.h2.dao.ISuministraDAO;
import com.crud.h2.dto.Suministra;

@Service
public class SuministraServiceImpl implements ISuministraService {

	@Autowired
	ISuministraDAO iSuministraDAO;
	
	@Override
	public List<Suministra> listarSuministra() {
		
		return iSuministraDAO.findAll();
	}

	@Override
	public Suministra guardarSuministra(Suministra suministra) {

		return iSuministraDAO.save(suministra);
	}

	@Override
	public Suministra suministraXID(int codigo_suministra) {

		return iSuministraDAO.findById(codigo_suministra).get();
	}

	@Override
	public Suministra actualizarSuministra(Suministra suministra) {

		return iSuministraDAO.save(suministra);
	}

	@Override
	public void eliminarSuministra(int codigo_suministra) {

		iSuministraDAO.deleteById(codigo_suministra);
		
	}

}
