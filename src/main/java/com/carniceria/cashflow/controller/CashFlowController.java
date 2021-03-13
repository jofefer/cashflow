package com.carniceria.cashflow.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.carniceria.cashflow.intefaceService.ICashFlowLineaService;
import com.carniceria.cashflow.intefaceService.IEstadisticasService;
import com.carniceria.cashflow.intefaceService.IHerarquiaService;
import com.carniceria.cashflow.model.CashFlowLinea;
import com.carniceria.cashflow.model.Herarquia;
import com.carniceria.cashflow.service.CashFlowLineaService;
import com.carniceria.cashflow.utils.Pair;

@Controller
@RequestMapping
public class CashFlowController {

	@Autowired
	private ICashFlowLineaService service;
	
	@Autowired
	private IHerarquiaService herarquiaService;
	
	@Autowired
	private IEstadisticasService estadisticasService;
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		//List<CashFlowLinea> lineas = this.service.listar();
		//model.addAttribute("lineas",lineas);
		
		return findPaginated(1, "date", "desc", model);
		
		

		//return "index";
	}
	
	@RequestMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("linea", new CashFlowLinea());
		List<Herarquia> herarquia = this.herarquiaService.listar();
		model.addAttribute("herarquia1", ingresoGastoTipo(herarquia));
		
		return "create-form";
	}
	
	@PostMapping("/save")
	public String guardar(@Validated CashFlowLinea linea ,Model model) {
		this.service.save(linea);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<CashFlowLinea> linea = this.service.listarId(id);
		List<Herarquia> herarquia = this.herarquiaService.listar();
		model.addAttribute("linea", linea);
		model.addAttribute("herarquia1", ingresoGastoTipo(herarquia));
		return "create-form";
	}
	
	@GetMapping("eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		this.service.delete(id);
		return "redirect:/listar";
	}
	
	
	@GetMapping("/estadisticas")
	public String mostarEstadisticas(Model model) {
		double[] estadisticasIngreso = this.estadisticasService.ingresosGastosPorMes("ingreso");
		double[] estadisticasGasto = this.estadisticasService.ingresosGastosPorMes("gasto");

		model.addAttribute("stdIngreso",estadisticasIngreso);
		model.addAttribute("stdGasto",estadisticasGasto);
		model.addAttribute("beneficioNeto", this.estadisticasService.beneficioNeto());
		
		return "estadisticas";
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		
		int pageSize = 25;
		System.out.println("estoy en el paginado");
		Page<CashFlowLinea> page = service.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<CashFlowLinea> cashFlowList = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("lineas", cashFlowList);
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDirection", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		return "index";
	}
	
	
	
	
	private List<Pair> ingresoGastoTipo(List<Herarquia> lista){
		ArrayList<Pair> devolver = new ArrayList<>();
		for(Herarquia linea: lista) {
			Pair pair = new Pair(linea.getIngresoGasto(), linea.getTipo());
			if(!devolver.contains(pair)) {
				devolver.add(pair);
			}
		}
		return devolver;
	}
	
	private List<Pair> tipoSubtipo(List<Herarquia> lista){
		ArrayList<Pair> devolver = new ArrayList<>();
		for(Herarquia linea: lista) {
			Pair pair = new Pair(linea.getTipo(), linea.getSubtipo());
			if(!devolver.contains(pair)) {
				devolver.add(pair);
			}
		}
		return devolver;
	}
}
