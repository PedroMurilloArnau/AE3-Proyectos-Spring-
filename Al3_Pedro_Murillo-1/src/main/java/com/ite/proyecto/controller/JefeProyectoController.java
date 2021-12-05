package com.ite.proyecto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.ite.proyecto.modelo.daos.IntProducto;
import com.ite.proyecto.modelo.daos.IntProyectoConEmpleado;
import com.ite.proyecto.modelo.daos.IntProyectoConProducto;
import com.ite.proyecto.modelo.daos.IntProyectoDao;
import com.ite.proyectos.beans.Empleado;
import com.ite.proyectos.beans.Proyecto;
import com.ite.proyectos.beans.ProyectoConEmpleado;
import com.ite.proyectos.beans.ProyectoConProducto;

@Controller
@RequestMapping("/jefe/")
public class JefeProyectoController {
	@Autowired
	private IntProyectoDao proc;
	@Autowired
	private IntEmpleadosDao emp;
	@Autowired
	private IntProyectoConEmpleado imp;
	@Autowired
	private IntProyectoConProducto pcp;
	@Autowired
	private IntProducto produ;

/**Este método desarrollara las principales funcionalidades de los empleados
 * de perfil Jefe de Proyecto, de tipo "2". Esta página desglosara los proyectos
 * activos que tienen como jefe, el empleado logueado.
 * 	
 * @param model
 * @param sesion
 * @return jefeIndex.jsp
 */
@GetMapping("proyectos")
public String despliegueProyectos(Model model,HttpSession sesion) {
	Empleado emp = (Empleado) sesion.getAttribute("empleado");
	model.addAttribute("listaProyectos", proc.proyectoJefeAct(emp.getIdEmpl()));
	
	return "jefesIndex";
	
}

/**Mediante este método nos redirigira al proyecto determinado mediante PathVariable.
 * Este método nos proporcionara los detalles del proyecto mostrandono tanto los empleados
 * que están en el proyecto como los productos que están asociado para este proyecto.
 * 
 * @param model
 * @param idProyecto
 * @return detalles.jsp
 */
@GetMapping("verDetalle/{id}")
public String verdetalles(Model model,@PathVariable("id")String idProyecto) {

	
	
	model.addAttribute("proyecto", proc.findByidProyecto(idProyecto));
	model.addAttribute("ListaEmple", proc.findByidProyecto(idProyecto).getProyectoConEmpleados());
	model.addAttribute("ListaProducto", proc.findByidProyecto(idProyecto).getProyectoConProducto());
	return "detalles";

}

/**Mediante este método accederemos a un página con un formulario donde se nos presentaran
 * los empleados correspondientes al perfil de Operativo, de tipo "3".Además pasamos el proyecto.
 * 
 * @param model
 * @param idProyecto
 * @return AsignarEmple.jsp
 */
@GetMapping("AsignarEmpleados/{id}")
public String asignarEmpleado(Model model,@PathVariable("id")String idProyecto) {

	
	model.addAttribute("listaEmpleados", emp.findByPerfile(3));
	model.addAttribute("proyecto", proc.findByidProyecto(idProyecto));
	return "AsignarEmple";
}

/**Mediante este método podemos recoger los datos del formulario para dar de alta
 * empleados a proyectos, estos datos nos llegaran mediante perámtros de idEmpledo,
 * el cual nos llevara al empleado en cuestión, luego crearemos el ProyectoConEmpleado
 * luego este se lo asignaremos al proyecto en cuestion.
 * 
 * @param idProyecto
 * @param idEmpl
 * @param atts
 * @return /jefe/proyectos
 */
@PostMapping("AsignarEmpleados/{id}")
public String procAsignarEmpleados(@PathVariable("id")String idProyecto,@RequestParam("empl")int idEmpl, RedirectAttributes atts) {
	ProyectoConEmpleado prol = new ProyectoConEmpleado();
	prol.setEmpleado(emp.findById(idEmpl));
	imp.addProyectoConEmpleado(prol);

	System.out.println(imp.findAll().size());
	
	System.out.println(imp.findBynumeroOrden(imp.findAll().size()));
	proc.findByidProyecto(idProyecto).addProyectoConEmpleado(imp.findBynumeroOrden(imp.findAll().size()));
	
	System.out.println("El proyecto de id=" + idProyecto +". Consta de " +proc.findByidProyecto(idProyecto).getProyectoConEmpleados().size()+ " empledos.");
	
	atts.addFlashAttribute("mensaje","Empleados añadidos correctamente al proyecto.");
	
	return "redirect:/jefe/proyectos";
}

/**Mediante este método desplegaremos un formulario para asignar productos a un
 * proyecto. A este formulario le pasaremos los diferentes productos que tenemos.
 * 
 * @param model
 * @param idProyecto
 * @return AsignarProductos.jsp
 */
@GetMapping("AsignarProductos/{id}")
public String AsignacionProductos(Model model,@PathVariable("id")String idProyecto) {
	
	model.addAttribute("listaProductos", produ.findALL());
	model.addAttribute("proyecto", proc.findByidProyecto(idProyecto));
	return "AsignarProducto";
}

/**Mediante este metodo recogeremos los parámetros del producto seleccionado dentro
 * del proyecto seleccionado. Se lo pasaremos mediante el idProyecto de tipo PathVariable.
 * El producto se lo asociamos a ProyectoConProducto y este a su vez se lo asociaremos al
 * proyecto.
 * 
 * @param idProyecto
 * @param idProducto
 * @param atts
 * @return /jefe/proyectos
 */
@PostMapping("AsignarProductos/{id}")
public String AsignarProductos(@PathVariable("id")String idProyecto,@RequestParam("prod")int idProducto, RedirectAttributes atts) {
	ProyectoConProducto pcpl = new ProyectoConProducto();
	pcpl.setProducto(produ.findByIdProducto(idProducto));
	pcp.addProyectoConProducto(pcpl);
	System.out.println(pcp.findAll().size());
	proc.findByidProyecto(idProyecto).addProyectoConProducto(pcp.findBynumeroOrden(pcp.findAll().size()));
	atts.addFlashAttribute("mensaje","Productos añadidos correctamente al proyecto.");
	
	return "redirect:/jefe/proyectos";
}
}
