package com.carniceria.cashflow.intefaceService;

import java.util.List;
import java.util.Map;


public interface IEstadisticasService {

	public double[] ingresosGastosPorMes(String ingresoGasto);
	public List<Integer> gastosPorMes();
	public double beneficioNeto();
	public double ventasTotales();
	
}
