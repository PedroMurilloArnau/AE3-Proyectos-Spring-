package com.ite.proyecto.modelo.daos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.ite.proyectos.beans.Empleado;

@Repository
public class EmpleadosDaolmpl implements IntEmpleadosDao, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<Empleado> lista;
	private IntPerfileDao perfil = new PerfilesDaolmpl();
	private IntDepartamentoDao depa = new DepartamentoDaolmpl();
	private int contador;
	
	public EmpleadosDaolmpl() {
		lista = new ArrayList<Empleado>();
		cargarDatos();
	}
	
	public void cargarDatos() {
		
		
		lista.add(new Empleado(1, "Pepe@cuhunflu.com","Contrasena123", new Date(),new Date(),"Pepito Perez", new BigDecimal("50.000"), depa.findById(2), perfil.findById(1)));
		lista.add(new Empleado(2, "Manuela@cuhunflu.com","Contraecho", new Date(),new Date(),"Manuela Carmena", new BigDecimal("60.000"), depa.findById(1), perfil.findById(1)));
		lista.add(new Empleado(3, "AlejandraM@cucunflu.com","Palillo", new Date(),new Date(), "Alejandra", new BigDecimal("40.000"), depa.findById(1), perfil.findById(2)));
		lista.add(new Empleado(4, "AlejandraM@cucunflu.com","Palillo", new Date(),new Date(), "Perdilla", new BigDecimal("10.000"), depa.findById(1), perfil.findById(3)));
		lista.add(new Empleado(5, "AlejandraM@cucunflu.com","Palillo", new Date(),new Date(), "Juanillo", new BigDecimal("10.000"), depa.findById(1), perfil.findById(3)));
		lista.add(new Empleado(6, "AlejandraM@cucunflu.com","Palillo", new Date(),new Date(), "Belenchu", new BigDecimal("20.000"), depa.findById(1), perfil.findById(3)));
		lista.add(new Empleado(7, "AlejandraM@cucunflu.com","Palillo", new Date(),new Date(), "Malena", new BigDecimal("10.000"), depa.findById(1), perfil.findById(3)));
		contador = lista.size(); 
	}
	
	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public int addUsuario(Empleado empleado) {
		if (!lista.contains(empleado)){
			empleado.setIdEmpl(++contador);
			lista.add(empleado);
		return 1;
		}
		return 0;
	}

	@Override
	//Busca de la lista el usuario
	public Empleado findByNombrePasword(int idEmpl, String correo, String pasword) {
		
		
		for (Empleado usu: lista) {
			if(usu.getIdEmpl() == idEmpl) {
				if(usu.getCorreo().equals(correo)) {
					if(usu.getPasword().equals(pasword)) {
					
		
					return usu;		
					}
				}
			}
		
		}
		return null;
	}
	

	@Override
	public Empleado findById(int idEmpl) {
		
		Empleado aux = new Empleado();
		aux.setIdEmpl(idEmpl);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return null;
		else
		return lista.get(pos);
	}

	@Override
	public List<Empleado> findByPerfile(int idPerfil) {
		List<Empleado> aux = new ArrayList<Empleado>();
		for (Empleado usu: lista) {
			if(usu.getPerfile().getIdPerfil()== idPerfil) {
				aux.add(usu);
			}
		
		}
		return aux;
	}
}


