package com.carniceria.cashflow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.carniceria.cashflow.intefaceService.ICashFlowLineaService;
import com.carniceria.cashflow.interfaces.ICashFlowLinea;
import com.carniceria.cashflow.model.CashFlowLinea;




@Service
public class CashFlowLineaService implements ICashFlowLineaService {

	@Autowired
	private ICashFlowLinea data;
	
	@Override
	public List<CashFlowLinea> listar() {
		List<CashFlowLinea> lineas = (List<CashFlowLinea>) this.data.findAll();
		return lineas;
	}

	@Override
	public Optional<CashFlowLinea> listarId(int id) {
		return this.data.findById(id);
	}

	@Override
	public int save(CashFlowLinea linea) {
		int res = 0;
		CashFlowLinea datos = data.save(linea);
		if (!datos.equals(null)) {
			res = 1;	
		}
		return res;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.data.deleteById(id);
	}

	@Override
	public Page<CashFlowLinea> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize, sort);
		return this.data.findAll(pageable);
	}
	

}
