package com.ite.proyecto.controller;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.proyecto.modelo.daos.IntEmpleadosDao;
import com.ite.proyecto.modelo.daos.IntProyectoConEmpleado;
import com.ite.proyecto.modelo.daos.IntProyectoDao;
import com.ite.proyectos.beans.Empleado;
import com.ite.proyectos.beans.Proyecto;
import com.ite.proyectos.beans.ProyectoConEmpleado;

@Controller
@RequestMapping("/jefe/")
public class JefeProyectoController {
	@Autowired
	private IntProyectoDao proc;
	@Autowired
	private IntEmpleadosDao emp;
	@Autowired
	private IntProyectoConEmpleado imp;
	
@GetMapping("proyectos")
public String despliegueProyectos(Model model) {
	
	model.addAttribute("listaProyectos", proc.proyectoActivos());
	
	return "jefesIndex";
	
}
@GetMapping("verDetalle/{id}")
public String verdetalles(Model model,@PathVariable("id")String idProyecto) {
	System.out.println("Es lo que necesito "+ idProyecto);
	Proyecto proye = proc.findByidProyecto(idProyecto);
	System.out.println(proye);
	
	
	model.addAttribute("proyecto", proc.findByidProyecto(idProyecto));
	model.addAttribute("ListaEmple", proc.findByidProyecto(idProyecto).getProyectoConEmpleados());
	return "detalles";

}
@GetMapping("AsignarEmpleados/{id}")
public String asignarEmpleado(Model model,@PathVariable("id")String idProyecto) {
	List<Empleado> aux = new ArrayList<Empleado>();
	
	for(Empleado emple : emp.findAll()) {
		if(emple.getPerfile().getIdPerfil() == 3) {
			aux.add(emple);
			}	
		}
	
	model.addAttribute("listaEmpleados", aux);
	model.addAttribute("proyecto", proc.findByidProyecto(idProyecto));
	return "AsignarEmple";
}
@PostMapping("AsignarEmpleados/{id}")
public String procAsignarEmpleados(@PathVariable("id")String idProyecto,@RequestParam("empl")int idEmpl, RedirectAttributes atts) {
	ProyectoConEmpleado prol = new ProyectoConEmpleado();
	prol.setEmpleado(emp.findById(idEmpl));
	imp.addProyectoConEmpleado(prol);
	
	if(proc.findByidProyecto(idProyecto).getProyectoConEmpleados() == null) {
		List<ProyectoConEmpleado> aux = new ArrayList<ProyectoConEmpleado>();
		aux.add(prol);
	proc.findByidProyecto(idProyecto).setProyectoConEmpleados(aux);
	}
	else {
		proc.findByidProyecto(idProyecto).addProyectoConEmpleado(prol);
	}
		
	System.out.println("El proyecto de id=" + idProyecto +". Consta de " +proc.findByidProyecto(idProyecto).getProyectoConEmpleados().size()+ " empledos.");
	
	atts.addFlashAttribute("mensaje","Empleados añadidos correctamente al proyecto.");
	
	return "redirect:/jefe/proyectos";
}
}
