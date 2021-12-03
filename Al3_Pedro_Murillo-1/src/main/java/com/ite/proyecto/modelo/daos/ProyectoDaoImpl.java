package com.ite.proyecto.modelo.daos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.ite.proyectos.beans.Proyecto;

@Repository
public class ProyectoDaoImpl implements IntProyectoDao,Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private List<Proyecto> lista;
	private List<Proyecto> listAct;
	private IntClienteDao clien = new ClienteDaoImpl();
	private IntEmpleadosDao jefe = new EmpleadosDaolmpl();
	
	public ProyectoDaoImpl() {
		listAct = new ArrayList<Proyecto>();
		lista = new ArrayList<Proyecto>();
		cargarDatos();
	}
	
	public void cargarDatos() {
	
		lista.add(new Proyecto("1por", null, null, null,"Activo",null, null, null, null, null, null, clien.findByCif("50900628L"), jefe.findById(3)));
		lista.add(new Proyecto("1perd", null, null, null,"terminado",null,  null, null, null, null, null, clien.findByCif("50900628L"), jefe.findById(3)));
	}

	@Override
	public List<Proyecto> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}
	
	@Override
	public int addProyecto(Proyecto proyecto) {
		if (!lista.contains(proyecto)){
			proyecto.setEstado("Activo");
			lista.add(proyecto);
		return 1;
		}
		return 0;
	}

	@Override
	public int terminarProyecto(Proyecto proyecto, BigDecimal costeReal, Date fechaFinReal) {
		if (lista.contains(proyecto)) {
			proyecto.setCosteReal(costeReal);
			proyecto.setFechaFinReal(fechaFinReal);
			return 1;
		}
		return 0;
	}

	@Override
	public Proyecto findByidProyecto(String idProyecto) {
		
		Proyecto aux = new Proyecto();
		aux.setIdProyecto(idProyecto);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return null;
		else
		return lista.get(pos);
	}

	@Override
	public List<Proyecto> proyectoActivos() {
		for (Proyecto usu: lista) {
			if (usu.getEstado() =="Activo"){
				Proyecto carf = usu;
				listAct.add(carf);
				}
		}
		return listAct;
	}
}

