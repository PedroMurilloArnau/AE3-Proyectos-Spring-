package com.ite.proyecto.modelo.daos;

import java.util.List;

import com.ite.proyectos.beans.Departamento;



public interface IntDepartamentoDao {
	
	List<Departamento> findAll();
	
	int addTipo(Departamento departamento);
	
	Departamento findById(int idDepar);

}

