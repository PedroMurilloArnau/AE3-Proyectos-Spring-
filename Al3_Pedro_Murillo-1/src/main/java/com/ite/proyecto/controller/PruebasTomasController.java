package com.ite.proyecto.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ite.proyecto.modelo.daos.IntClienteDao;
import com.ite.proyecto.modelo.daos.IntProyectoDao;
import com.ite.proyectos.beans.Proyecto;

@Controller
public class PruebasTomasController {
@Autowired
private IntProyectoDao proc;
@Autowired
private IntClienteDao clic;

//Probando Init Binder
@InitBinder
	public void initBinder(WebDataBinder webdataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		webdataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,false));
}

@GetMapping("/pruebas")
public String ProbandoMetodosPruebas(Model model) {
	model.addAttribute("listaClientes", clic.findAll());
	return"pruebasTomas";
}
@PostMapping("/pruebas")
public String RecgidaDatosProyecto(Proyecto proyecto) {
	System.out.println(proyecto);
	proc.addProyecto(proyecto);
	return"pruebasTomas";

}
}
