package com.ite.proyecto.modelo.daos;

import java.util.List;
import com.ite.proyectos.beans.Perfile;


public interface IntPerfileDao {
	
	List<Perfile> findAll();
	
	int addTipo(Perfile perfile);
	
	Perfile findById(int idPerfil);

}

