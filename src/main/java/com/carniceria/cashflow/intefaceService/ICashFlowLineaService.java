package com.carniceria.cashflow.intefaceService;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.carniceria.cashflow.model.CashFlowLinea;



public interface ICashFlowLineaService {

	public List<CashFlowLinea> listar();
	public Optional<CashFlowLinea> listarId(int id);
	public int save(CashFlowLinea linea);
	public void delete(int id);
	public Page<CashFlowLinea> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
