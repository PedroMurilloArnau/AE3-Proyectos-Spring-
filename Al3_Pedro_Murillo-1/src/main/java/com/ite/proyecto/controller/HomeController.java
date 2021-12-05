package com.ite.proyecto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.proyecto.modelo.daos.IntEmpleadosDao;
import com.ite.proyectos.beans.Empleado;







@Controller

public class HomeController {

@Autowired
private IntEmpleadosDao emp ;


	/**El login será la página principal que nos desplegara un formulario
	 * para que los diferentes empleados se puedan logear.
	 * 
	 * @param atts
	 * @param model
	 * @param sesion
	 * @return login.jsp
	 */
	@GetMapping("/login")
	public String login (RedirectAttributes atts,Model model, HttpSession sesion) {
		if (sesion.getAttribute("usario") != null) {
		atts.addFlashAttribute("mensajelogin", "Una vez logeado tines que darle al boton Logout.");
		return "redirect:/inicio";
		}
		model.addAttribute("mensaje", "Introduzca su nombre de usuario y contraseña");
		return "login";
	
	}
	
	/**Mediante este método nos recogera el formulário del login, donde, dependiendo
	 * del usuario que se logee nos redigirá a los diferentes index que se requieran.
	 * 
	 * @param atts
	 * @param idEmpl
	 * @param correo
	 * @param pasword
	 * @param sesion
	 * @return /login o /jefe/proyectos o /gestion
	 */
	
	@PostMapping("/login")
	public String logearse (RedirectAttributes atts, @RequestParam("IdEmpl") int idEmpl,@RequestParam("correo") String correo, @RequestParam("pasword") String pasword, HttpSession sesion) {
		System.out.println(idEmpl);
		System.out.println(pasword);
		System.out.println(correo);
		
		Empleado emple = emp.findByNombrePasword(idEmpl, correo, pasword);
		System.out.println(emple);
		if (emple == null) {
			atts.addFlashAttribute("mensajelogin","Login incorrecto");
			return "redirect:/login";
		}
		
		if(emple.getPerfile().getIdPerfil() ==1) {
		sesion.setAttribute("empleado", emple);
		return "redirect:/gestion";}
		if(emple.getPerfile().getIdPerfil() ==2) {
		sesion.setAttribute("empleado", emple);
		return "redirect:/jefe/proyectos";
		}
		return "redirec:/login";
	}
	/**Mediante este método nos borrara de la sesion el usuario y nos llevará
	 * de nuevo a la pagina principal.
	 * 
	 * @param sesion
	 * @param atts
	 * @return /login
	 */
	@GetMapping("/logout")
	public String salirAlLogin( HttpSession sesion,RedirectAttributes atts) {
		sesion.removeAttribute("empleado");
		//mata la sesion de forma definitiva.
		sesion.invalidate();
		atts.addAttribute("mensajelogin", "Realizado LogOut");
		return "redirect:/login";
	}
}
		