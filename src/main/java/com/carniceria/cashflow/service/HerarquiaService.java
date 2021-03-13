package com.carniceria.cashflow.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carniceria.cashflow.intefaceService.IHerarquiaService;
import com.carniceria.cashflow.interfaces.IHerarquia;
import com.carniceria.cashflow.model.Herarquia;


@Service
public class HerarquiaService implements IHerarquiaService{

	@Autowired
	private IHerarquia data;
	
	@Override
	public List<Herarquia> listar() {
		// TODO Auto-generated method stub
		return (List<Herarquia>) this.data.findAll();
	}

	@Override
	public Optional<Herarquia> listarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Herarquia linea) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}







}
