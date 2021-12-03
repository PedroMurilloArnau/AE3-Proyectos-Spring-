package com.ite.proyecto.modelo.daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ite.proyectos.beans.Departamento;



public class DepartamentoDaolmpl implements IntDepartamentoDao, Serializable{
/**
 * 
 */
	private static final long serialVersionUID = 1L;
	
	private List<Departamento> lista;
	
	public DepartamentoDaolmpl(){
		lista = new ArrayList<Departamento>();
		cargarDatos();
		
	}
	private void cargarDatos() {
		
		//IntEmpleadosDao jefe = new EmpleadosDaolmpl();
		
		lista.add(new Departamento(1,"ventas@cuhunflu.com","Ventas", null));
		lista.add(new Departamento(2, "marketing@cuhunflu.com", "Marketing", null));
		
		
		
	}
	@Override
	public List<Departamento> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}
	@Override
	public int addTipo(Departamento departamento) {
		// TODO Auto-generated method stub
		if(!lista.contains(departamento)) {
			lista.add(departamento);
			return 1;
		}
		return 0;
	}
	
	@Override
	public Departamento findById(int idDepar) {
		Departamento departamento = new Departamento();
		departamento.setIdDepar(idDepar);
		int pos = lista.indexOf(departamento);
		if (pos == -1)
		return null;
		else
			return lista.get(pos);
	}
}
