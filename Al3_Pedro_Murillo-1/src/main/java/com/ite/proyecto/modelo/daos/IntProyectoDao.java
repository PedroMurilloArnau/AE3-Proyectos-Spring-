package com.ite.proyecto.modelo.daos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ite.proyectos.beans.Proyecto;

public interface IntProyectoDao {
	
	List<Proyecto> findAll();
	
	List<Proyecto> proyectoActivos();
	
	
	int terminarProyecto(Proyecto proyecto, BigDecimal costeReal,Date fechaFinReal);

	int addProyecto(Proyecto proyecto);
	
	Proyecto findByidProyecto(String idProyecto);

}
