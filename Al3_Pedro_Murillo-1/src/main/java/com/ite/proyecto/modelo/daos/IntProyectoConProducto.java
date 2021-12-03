package com.ite.proyecto.modelo.daos;

import java.util.List;

import com.ite.proyectos.beans.ProyectoConProducto;

public interface IntProyectoConProducto {
	
	List<ProyectoConProducto> findAll();
	
	int addProyectoConProducto(ProyectoConProducto proyectoConProducto);
	
	ProyectoConProducto findBynumeroOrden(int numeroOrden);

}
