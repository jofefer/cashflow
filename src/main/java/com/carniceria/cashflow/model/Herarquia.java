package com.carniceria.cashflow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="herarquia_prueba")
public class Herarquia {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String ingresoGasto;
	private String tipo;
	private String subtipo;
	
	public Herarquia() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIngresoGasto() {
		return ingresoGasto;
	}

	public void setIngresoGasto(String ingresoGasto) {
		this.ingresoGasto = ingresoGasto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSubtipo() {
		return subtipo;
	}

	public void setSubtipo(String subtipo) {
		this.subtipo = subtipo;
	}
	
	
}
