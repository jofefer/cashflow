package com.carniceria.cashflow.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carniceria.cashflow.model.Herarquia;

@Repository
public interface IHerarquia extends CrudRepository<Herarquia, Integer> {
	
}
