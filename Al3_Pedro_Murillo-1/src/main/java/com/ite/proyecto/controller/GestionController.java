package com.ite.proyecto.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sound.midi.MidiEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.proyecto.modelo.daos.EmpleadosDaolmpl;
import com.ite.proyecto.modelo.daos.IntClienteDao;
import com.ite.proyecto.modelo.daos.IntEmpleadosDao;
import com.ite.proyecto.modelo.daos.IntProducto;
import com.ite.proyecto.modelo.daos.IntProyectoDao;
import com.ite.proyectos.beans.Cliente;
import com.ite.proyectos.beans.Empleado;
import com.ite.proyectos.beans.Producto;
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
@Autowired
private IntProducto produ;

/**Mediante Init binder modificamos los datos que nos llegan de tipo Perfil
 * de Gestion, tipo "1".
 * @param webdataBinder
 */
@InitBinder
public void initBinder(WebDataBinder webdataBinder) {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	webdataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,false));
}

/**Lleva a la página principal de los empleados de perfin Gestión.
 * Desde ella se procesara todas las funciones de los empleados de tipo
 * gestión.
 * @param model
 * @param sesion
 * @return gestionIndex.jsp
 */
@GetMapping("")
public String gestionar(Model model, HttpSession sesion) {

	model.addAttribute("listaProyectos", pord.proyectoActivos());
	model.addAttribute("listaJefes", emp.findByPerfile(2));
	model.addAttribute("listaClientes", clic.findAll());
	
	return "/gestionIndex";
}

/**Procesa las altas de proyecto mediante la llegada de diferentes parámetros desde
 * el jsp. Finalmente se creará un Proyecto que se indexara en la lista de proyectos.
 * 
 * @param cif
 * @param idEmpl
 * @param idProyecto
 * @param sesion
 * @param atts
 * @return	/gestion
 */
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
/**Procesa el terminar proyectos realizados desde el jsp de gestion
 * mediante este método daríamos termino a los proyectos. En este método
 * recogemos los parámetros requeridos y modificamos el proyecto requerido.
 * 
 * @param fechaFinReal
 * @param idProyecto
 * @param costeReal
 * @param sesion
 * @param atts
 * @return /gestion
 */
@PostMapping("/terminarProyecto")
public String terminarProyecto(@RequestParam("fechaFinReal") Date fechaFinReal,@RequestParam("idProyecto") String idProyecto,@RequestParam("costeReal") int costeReal, HttpSession sesion,RedirectAttributes atts) {
	
	Proyecto proc = (pord.findByidProyecto(idProyecto));
	proc.setEstado("terminado");
	proc.setFechaFinReal(new Date());
	proc.setCosteReal(new BigDecimal(costeReal));
	
	System.out.println(idProyecto);
	System.out.println(proc);
	atts.addFlashAttribute("mensajeAlta", "Proyecto Terminado correctamente");
	return "redirect:/gestion";
}

/**Mediante este método damos de alta producto mediante Data Binder, recogiendo
 * los difrentes parámetros de Producto, que se ingresaran en un nuevo producto
 * este producto a su vez se indexara a los distintos productos.
 * 
 * @param producto
 * @param sesion
 * @param atts
 * @return /gestion
 */
@PostMapping("/altaProducto")
public String altaProducto(Producto producto, HttpSession sesion,RedirectAttributes atts) {
	System.out.println(producto);
	produ.addProdcucto(producto);
	for(Producto por: produ.findALL()) {
		System.out.println(por);
	}
	
	atts.addFlashAttribute("mensajeAlta", "Producto dado de alta correctamente");
	return "redirect:/gestion";
}
}