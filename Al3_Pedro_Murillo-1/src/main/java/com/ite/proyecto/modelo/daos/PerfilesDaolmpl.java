package com.ite.proyecto.modelo.daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ite.proyectos.beans.Perfile;



public class PerfilesDaolmpl implements IntPerfileDao, Serializable{
/**
 * 
 */
	private static final long serialVersionUID = 1L;
	
	private List<Perfile> lista;
	
	public PerfilesDaolmpl(){
		lista = new ArrayList<Perfile>();
		cargarDatos();
		
	}
	private void cargarDatos() {
		
		lista.add(new Perfile(1,"Control de Gestion"));
		lista.add(new Perfile(2,"Jefe de Proyecto"));
		lista.add(new Perfile(3,"Operativo"));
		lista.add(new Perfile(4,"Recursos Humanos"));
		
		
	}
	@Override
	public List<Perfile> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}
	@Override
	public int addTipo(Perfile perfile) {
		// TODO Auto-generated method stub
		if(!lista.contains(perfile)) {
			lista.add(perfile);
			return 1;
		}
		return 0;
	}
	
	@Override
	public Perfile findById(int idPerfil) {
		Perfile perfile = new Perfile();
		perfile.setIdPerfil(idPerfil);
		int pos = lista.indexOf(perfile);
		if (pos == -1)
		return null;
		else
			return lista.get(pos);
	}
}
