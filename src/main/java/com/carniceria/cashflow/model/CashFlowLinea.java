package com.carniceria.cashflow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cash_flow_diario")
public class CashFlowLinea {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	private String ingresoGasto;
	private String date;
	private String tipo;
	private String subtipo;
	private String concepto;
	private double valor;
	
	
	public CashFlowLinea() {
		
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


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
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


	public String getConcepto() {
		return concepto;
	}


	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}
