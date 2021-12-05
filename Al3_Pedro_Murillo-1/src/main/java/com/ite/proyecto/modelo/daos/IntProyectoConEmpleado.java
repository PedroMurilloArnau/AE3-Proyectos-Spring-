package com.ite.proyecto.modelo.daos;

import java.util.List;

import com.ite.proyectos.beans.ProyectoConEmpleado;

public interface IntProyectoConEmpleado {
	
	List<ProyectoConEmpleado> findAll();
	
	int addProyectoConEmpleado(ProyectoConEmpleado proyectoConEmpleado);
	
	ProyectoConEmpleado findBynumeroOrden(int numeroOrden);
	

}
