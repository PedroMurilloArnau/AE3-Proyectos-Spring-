package com.ite.proyecto.modelo.daos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.beans.Producto;

@Repository
public class ProductoDaoImpl implements IntProducto, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<Producto> lista;
	private int contador;
	
	public ProductoDaoImpl() {
	
		lista = new ArrayList<Producto>();
		cargardatos();
	}
	public void cargardatos() {
		
		lista.add(new Producto(1,"Grapadora Proteus","Grapadora fuerte y resistente",new BigDecimal("15"),5));
		contador = lista.size();
	}
	@Override
	public List<Producto> findALL() {
		
		return lista;
	}

	@Override
	public Producto findByIdProducto(int idProducto) {
		
		Producto aux = new Producto();
		aux.setIdProducto(idProducto);
		int pos = lista.indexOf(aux);
		if(pos == -1)
		return null;
		else
		return lista.get(pos);
	}
	@Override
	public int addProdcucto(Producto producto) {
		if(!lista.contains(producto)) {
			producto.setIdProducto(++contador);
			lista.add(producto);
		return 1;
		}
		return 0;
	}
	
}
