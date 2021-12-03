package com.ite.proyecto.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sound.midi.MidiEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.proyecto.modelo.daos.EmpleadosDaolmpl;
import com.ite.proyecto.modelo.daos.IntClienteDao;
import com.ite.proyecto.modelo.daos.IntEmpleadosDao;
import com.ite.proyecto.modelo.daos.IntProyectoDao;
import com.ite.proyectos.beans.Cliente;
import com.ite.proyectos.beans.Empleado;
import com.ite.proyectos.beans.Proyecto;





@Controller
@RequestMapping("/gestion")
public class GestionController {
@Autowired
private IntEmpleadosDao emp ;
@Autowired
private IntClienteDao clic ;
@Autowired
private IntProyectoDao pord;


@GetMapping("")
public String gestionar(Model model, HttpSession sesion) {
	List<Empleado> aux = new ArrayList<Empleado>();
	
	for(Empleado emple : emp.findAll()) {
		if(emple.getPerfile().getIdPerfil() == 2) {
			aux.add(emple);
			}	
		}
	List<Proyecto> axa = new ArrayList<Proyecto>();
	
	for(Proyecto prosi : pord.findAll()) {
		if(prosi.getEstado() != "terminado"){
		axa.add(prosi);
	}
	}
	model.addAttribute("listaProyectos", pord.proyectoActivos());
	model.addAttribute("listaJefes", aux );
	model.addAttribute("listaClientes", clic.findAll());
	
	return "/gestionIndex";
}
@PostMapping("/altaProyecto")
public String gestAltaProyecto( @RequestParam("cliente") String cif ,@RequestParam("jefeProyecto") int idEmpl,@RequestParam("idProyecto") String idProyecto , HttpSession sesion,RedirectAttributes atts) {
	Proyecto proc = new Proyecto();
	proc.setCliente(clic.findByCif(cif));
	proc.setJefeProyecto(emp.findById(idEmpl));
	proc.setIdProyecto(idProyecto);
	proc.setEstado("Activo");
	pord.addProyecto(proc);
	System.out.println(proc);
	
	atts.addFlashAttribute("mensajeAlta", "Proyecto dado de alta");
	return "redirect:/gestion";
	
}
@PostMapping("/terminarProyecto")
public String terminarProyecto(@RequestParam("idProyecto") String idProyecto,@RequestParam("costeReal") int costeReal, HttpSession sesion,RedirectAttributes atts) {
	
	Proyecto proc = (pord.findByidProyecto(idProyecto));
	proc.setEstado("terminado");
	proc.setFechaFinReal(new Date());
	proc.setCosteReal(new BigDecimal(costeReal));
	
	System.out.println(idProyecto);
	System.out.println(proc);
	atts.addFlashAttribute("mensajeAlta", "Proyecto Terminado correctamente");
	return "redirect:/gestion";
}
@PostMapping("/altaProducto")
public String altaProducto(Model model, HttpSession sesion,RedirectAttributes atts) {
	atts.addFlashAttribute("mensajeAlta", "Producto dado de alta correctamente");
	return "redirect:/gestion";
}
}