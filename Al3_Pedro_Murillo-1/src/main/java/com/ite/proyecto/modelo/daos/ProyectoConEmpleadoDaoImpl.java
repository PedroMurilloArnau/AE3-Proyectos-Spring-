package com.ite.proyecto.modelo.daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.beans.ProyectoConEmpleado;
@Repository
public class ProyectoConEmpleadoDaoImpl implements IntProyectoConEmpleado, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<ProyectoConEmpleado> lista;
	private IntProyectoDao prot = new ProyectoDaoImpl();
	private IntEmpleadosDao emp = new EmpleadosDaolmpl();
	private int contador;
	
	public ProyectoConEmpleadoDaoImpl() {
		lista = new ArrayList<ProyectoConEmpleado>();
		cargarDatos();
	}
	
	public void cargarDatos() {
		
		lista.add(new ProyectoConEmpleado(1,new Date(),45,emp.findById(1),prot.findByidProyecto("1por")));
		contador = lista.size();
	}

	@Override
	public List<ProyectoConEmpleado> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public int addProyectoConEmpleado(ProyectoConEmpleado proyectoConEmpleado) {
		if (!lista.contains(proyectoConEmpleado)) {
			proyectoConEmpleado.setNumeroOrden(++contador);
		return 1;
		}
		return 0;
	}

	@Override
	public ProyectoConEmpleado findByIdEmpl(int IdEmpl) {
		// TODO Auto-generated method stub
		return null;
	}

}
