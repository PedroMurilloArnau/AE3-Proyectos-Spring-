package com.ite.proyecto.modelo.daos;

import java.util.List;

import com.ite.proyectos.beans.Producto;

public interface IntProducto {
	
	List<Producto> findALL();
	
	int addProdcucto(Producto producto);
	
	Producto findByIdProducto(int idProducto);

}
