package com.carniceria.cashflow.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carniceria.cashflow.intefaceService.IEstadisticasService;
import com.carniceria.cashflow.interfaces.ICashFlowLinea;
import com.carniceria.cashflow.model.CashFlowLinea;

@Service
public class Estadisticas implements IEstadisticasService {

	@Autowired
	private ICashFlowLinea data;
	
	@Override
	public double[] ingresosGastosPorMes(String ingresoGasto) {
		List<CashFlowLinea> lineas = (List<CashFlowLinea>) this.data.findAll();
		double[] ingresoMes = {0,0,0,0,0,0,0,0,0,0,0,0};
		//HashMap<String, Double> ingresoMes = new HashMap<>();
		
		for(CashFlowLinea linea: lineas) {
			
			LocalDate date = LocalDate.parse(linea.getDate());
			if(date.getYear() == date.now().getYear() && linea.getIngresoGasto().equals(ingresoGasto)) {
				int month = date.getMonthValue();
				
				//double tmpIngreso = ingresoMes[month-1];
				ingresoMes[month-1] += linea.getValor();
				//ingresoMes.put(month, tmpIngreso);
			}
			
			
		}
		
		
		return ingresoMes;
	}

	@Override
	public List<Integer> gastosPorMes() {
		return null;
	}

	@Override
	public double beneficioNeto() {
		List<CashFlowLinea> lineas = (List<CashFlowLinea>) this.data.findAll();
		double ingreso = 0;
		double gasto = 0;
		for(CashFlowLinea linea: lineas) {
			LocalDate date = LocalDate.parse(linea.getDate());
			if(date.getYear() == date.now().getYear()) {
				if(linea.getIngresoGasto().equals("ingreso")) {
					ingreso += linea.getValor();
				} else {
					gasto += linea.getValor();
				}
			}
		}
		return ingreso-gasto;
	}
	
}
