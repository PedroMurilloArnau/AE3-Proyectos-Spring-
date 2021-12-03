package com.ite.proyecto.modelo.daos;

import java.util.List;

import com.ite.proyectos.beans.Cliente;

public interface IntClienteDao {
	
	
	List<Cliente> findAll();

	int addCliente(Cliente cliente);
	
	Cliente findByCif(String cif);

}
