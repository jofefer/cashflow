package com.carniceria.cashflow.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carniceria.cashflow.model.Herarquia;
import com.carniceria.cashflow.utils.Pair;

@Repository
public interface IHerarquia extends JpaRepository<Herarquia, Integer> {
	
	@Query("SELECT new com.carniceria.cashflow.utils.Pair(h.ingresoGasto, h.familia) FROM Herarquia as h GROUP BY h.ingresoGasto, h.familia")
	List<Pair> herarquiaIngGastoFamilia();
	
	@Query("SELECT new com.carniceria.cashflow.utils.Pair(h.familia, h.tipo) FROM Herarquia as h GROUP BY h.familia, h.tipo")
	List<Pair> herarquiaFamiliaTipo();
	
	@Query("SELECT new com.carniceria.cashflow.utils.Pair(h.tipo, h.subtipo) FROM Herarquia as h GROUP BY h.tipo, h.subtipo")
	List<Pair> herarquiaTipoSubtipo();
}
