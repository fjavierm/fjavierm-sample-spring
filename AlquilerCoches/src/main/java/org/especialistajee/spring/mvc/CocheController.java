/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.especialistajee.spring.mvc;

import java.util.Date;

import javax.validation.Valid;

import org.especialistajee.Coche;
import org.especialistajee.spring.datos.ICocheDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author especialista
 */
@Controller
public class CocheController {

	@Autowired
	ICocheDAO dao;

	/*---------------------- LISTAR TODOS LOS COCHES  -----------------------------------------*/
	@RequestMapping("/listar.do")
	public String listar(@DateTimeFormat(pattern = "dd/mm/yy") @RequestParam(required = false) Date fecha, Model modelo) {
		if (fecha == null) {
			modelo.addAttribute("listado", this.dao.listar());
		} else {
			modelo.addAttribute("listado", this.dao.listarPosterioresA(fecha));
		}
		return "listar";
	}

	/*---------------------- ACTUALIZAR COCHE  -----------------------------------------*/
	@RequestMapping(value = "/editar.do", method = RequestMethod.GET)
	public String prepararEditar(Model modelo, @RequestParam(value = "matricula") String matricula) {
		modelo.addAttribute(this.dao.obtener(matricula));
		return "editar";
	}

	@RequestMapping(value = "/editar.do", method = RequestMethod.POST)
	public String procesarEditar(@Valid Coche coche, BindingResult result, Model modelo) {
		if (result.hasErrors()) {
			return "editar";
		} else {
			this.dao.actualizar(coche);
			return "redirect:listar.do";
		}
	}

	/*-----------------------INSERTAR NUEVO COCHE -------------------------------------*/
	@RequestMapping(value = "/crear.do", method = RequestMethod.GET)
	public String prepararCrear(Model modelo) {
		modelo.addAttribute(new Coche());
		return "crear";
	}

	@RequestMapping(value = "/crear.do", method = RequestMethod.POST)
	public String procesarCrear(@Valid Coche coche, BindingResult result, Model modelo) {
		if (result.hasErrors()) {
			return "crear";
		} else {
			return "redirect:listar.do";
		}
	}

	@RequestMapping(value = "/coches/{matricula}", method = RequestMethod.GET)
	@ResponseBody
	Coche getCoche(@PathVariable String matricula) {
		return this.dao.obtener(matricula);
	}
}
