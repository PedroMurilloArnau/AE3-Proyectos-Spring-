package com.ite.proyecto.modelo.daos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.beans.ProyectoConEmpleado;
import com.ite.proyectos.beans.ProyectoConProducto;

@Repository
public class ProyectoConProductoDaoImpl implements IntProyectoConProducto, Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private List<ProyectoConProducto> lista;
	private IntProyectoDao prot  = new ProyectoDaoImpl();
	private IntProducto produc = new ProductoDaoImpl();
	private int contador;
	
	public ProyectoConProductoDaoImpl() {
		lista = new ArrayList<ProyectoConProducto>();
		cargarDatos();
	}
	
	public void cargarDatos() {
		
		lista.add(new ProyectoConProducto(1,3,new BigDecimal("45"), produc.findByIdProducto(1), prot.findByidProyecto("1por")));
		contador = lista.size();
	}

	@Override
	public List<ProyectoConProducto> findAll() {
		
		return lista;
	}

	@Override
	public int addProyectoConProducto(ProyectoConProducto proyectoConProducto) {
		if (!lista.contains(proyectoConProducto)) {
			proyectoConProducto.setNumeroOrden(++contador);
			lista.add(proyectoConProducto);
		return 1;
		}
		return 0;
	}

	@Override
	public ProyectoConProducto findBynumeroOrden(int numeroOrden) {
		ProyectoConProducto aux = new ProyectoConProducto();
		aux.setNumeroOrden(numeroOrden);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return null;
		else
		return lista.get(pos);
		
	}
	
}
