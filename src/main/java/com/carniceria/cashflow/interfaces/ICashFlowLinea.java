package com.carniceria.cashflow.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carniceria.cashflow.model.CashFlowLinea;

@Repository
public interface ICashFlowLinea extends JpaRepository<CashFlowLinea, Integer> {


}
