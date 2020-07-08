package com.redsocial.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.redsocial.entidad.Golosina;
import com.redsocial.entidad.Pais;
import com.redsocial.servicio.GolosinaServicio;
import com.redsocial.servicio.PaisServicio;

@Controller
public class GolosinaController {

	@Autowired
	private GolosinaServicio golosinaServicio;
	
	@Autowired
	private PaisServicio paisServicio;
	
	@RequestMapping("/verCrudGolosina")
	public String verRegGolosina() {
		return "crudGolosina";
	}
	
	@RequestMapping("/consultaCrudGolosina")
	public String lista(String filtro, Model m) {
		List<Golosina> lista =  golosinaServicio.listaGolosinaPorNombre(filtro+"%");
		m.addAttribute("golosinas", lista);
		return "crudGolosina";
	}
	
	//Permite retornar datos en formato JSON, sirve para llenar el combo de categoria
	@ResponseBody
	@RequestMapping("/cargaPais")
	public List<Pais> cargaComboPais() {
		return paisServicio.listarTodos();
	}
	
	//session permite guardar en memoria objetos
	@RequestMapping("/registroDeGolosina")
	public String verRegGolosina(Golosina obj, HttpSession session) {
		Golosina objRep = golosinaServicio.insertaActualizaGolosina(obj);
		if(objRep == null) {
			session.setAttribute("MENSAJE", "Registro erróneo");
		}else {
			session.setAttribute("MENSAJE", "Registro exitos");
		}
		return "crudGolosina";
	}
	
	@RequestMapping("/eliminaCrudGolosina")
	public String elimina(int id, Model m) {
		golosinaServicio.eliminaGolosina(id);
		List<Golosina> lista =  golosinaServicio.listaGolosina();
		m.addAttribute("golosinas", lista);
		return "crudGolosina";
	}
}
