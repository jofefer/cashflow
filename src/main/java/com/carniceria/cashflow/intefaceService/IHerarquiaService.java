package com.carniceria.cashflow.intefaceService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


import com.carniceria.cashflow.model.Herarquia;

public interface IHerarquiaService {

	public List<Herarquia> listar();
	public Optional<Herarquia> listarId(int id);
	public int save(Herarquia linea);
	public void delete(int id);
	
}
