package com.crud.h2.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="suministra")
public class Suministra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_suministra;
	
	@ManyToOne
    @JoinColumn(name="codigo_pieza")
    private Pieza pieza;
	
	@ManyToOne
    @JoinColumn(name="codigo_proveedor")
    private Proveedor proveedor;
	
	@Column(name = "precio")
	private int precio;
	
	public Suministra() {
		
	}

	/**
	 * @param codigo_suministra
	 * @param pieza
	 * @param proveedor
	 * @param precio
	 */
	public Suministra(int codigo_suministra, Pieza pieza, Proveedor proveedor, int precio) {
		//super();
		this.codigo_suministra = codigo_suministra;
		this.pieza = pieza;
		this.proveedor = proveedor;
		this.precio = precio;
	}

	
	//Getters y Setters
	
	/**
	 * @return codigo_suministra
	 */
	public int codigo_suministra() {
		return codigo_suministra;
	}

	/**
	 * @param codigo_suministra
	 */
	public void setId(int codigo_suministra) {
		this.codigo_suministra = codigo_suministra;
	}
	
	/**
	 * @return pieza
	 */
	public Pieza getPieza() {
		return pieza;
	}

	/**
	 * @param pieza
	 */
	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}
	
	/**
	 * @return proveedor
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	/**
	 * @return precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * @param precio
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	//Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Suministra [codigo_suministra=" + codigo_suministra + ", pieza=" + pieza + ", proveedor=" + proveedor + ", precio=" + precio + "]";
	}
	
}
