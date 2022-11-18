package com.crud.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.h2.dto.Pieza;

public interface IPiezaDAO extends JpaRepository<Pieza, Integer> {

}
