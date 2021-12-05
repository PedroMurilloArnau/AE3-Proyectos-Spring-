package com.ite.proyecto.modelo.daos;

import java.util.List;

import com.ite.proyectos.beans.Empleado;





public interface IntEmpleadosDao {

	List<Empleado> findAll();
	
	List<Empleado> findByPerfile(int idPerfil);
	
	int addUsuario(Empleado empleado);
	
	Empleado findByNombrePasword(int idEmpl, String correo, String pasword);
	
	Empleado findById(int idEmpl);
	
	

}

