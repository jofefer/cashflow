package com.carniceria.cashflow.intefaceService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


import com.carniceria.cashflow.model.Herarquia;
import com.carniceria.cashflow.utils.Pair;

public interface IHerarquiaService {

	public List<Herarquia> listar();
	public Optional<Herarquia> listarId(int id);
	public int save(Herarquia linea);
	public void delete(int id);
	public List<Pair> herarquiaIngGastoFamilia();
	public List<Pair> herarquiaFamiliaTipo();
	public List<Pair> herarquiaTipoSubtipo();
	
}
