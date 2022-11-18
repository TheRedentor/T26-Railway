package com.crud.h2.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="piezas")
public class Pieza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_pieza;
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany
    @JoinColumn(name="codigo_pieza")
    private List<Suministra> suministra;
	
	public Pieza() {
		
	}

	/**
	 * @param codigo_pieza
	 * @param nombre
	 */
	public Pieza(int codigo_pieza, String nombre) {
		//super();
		this.codigo_pieza = codigo_pieza;
		this.nombre = nombre;
	}

	
	//Getters y Setters
	
	/**
	 * @return codigo_pieza
	 */
	public int getId() {
		return codigo_pieza;
	}

	/**
	 * @param codigo_pieza
	 */
	public void setId(int codigo_pieza) {
		this.codigo_pieza = codigo_pieza;
	}

	/**
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return suministra
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Suministra")
	public List<Suministra> getSuministra() {
		return suministra;
	}

	/**
	 * @param suministra
	 */
	public void setSuministra(List<Suministra> suministra) {
		this.suministra = suministra;
	}
	
	
	//Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Pieza [codigo_pieza=" + codigo_pieza + ", nombre=" + nombre + "]";
	}
}
