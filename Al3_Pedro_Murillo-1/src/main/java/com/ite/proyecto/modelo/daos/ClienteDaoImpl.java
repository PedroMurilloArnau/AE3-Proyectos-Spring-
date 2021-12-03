package com.ite.proyecto.modelo.daos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.proyectos.beans.Cliente;



@Repository
public class ClienteDaoImpl implements IntClienteDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Cliente> lista;
	private static int contadorId;
	
	public ClienteDaoImpl() {
		
		lista = new ArrayList<Cliente>();
		cargarDatos();
		contadorId = lista.size();
		
	}
	//cargamos los datos de los distinos Clientes que tenemos
	private void cargarDatos() {
		
		lista.add(new Cliente("50900628L","C/Riacardin n25 Madrid, Madrid",new BigDecimal("500.000"), "WanLi", 1));
		// TODO Auto-generated method stub
		
	}
	
	/**Metodo para buscar todos los clientes
	 * @return lista
	 * @Pedro
	 */
	@Override
	public List<Cliente> findAll() {
		return lista;
	}
	
	/**Metodo para añadir nuevos clientes
	 * modificamos el contador de clientes
	 * 
	 */
	@Override
	public int addCliente(Cliente cliente) {
		if (!lista.contains(cliente)){
			cliente.setNumeroCliente(++contadorId);
			lista.add(cliente);
		return 1;
		}
		return 0;
	}
	
	/**Buscar un cliente por su Cif creamos
	 * un Cliente y le añadimos el cif.
	 * Luego buscamos la posición del mismo por
	 * el Cif.
	 * @return Cliente
	 * 
	 */
	@Override
	public Cliente findByCif(String cif) {
		
		Cliente aux = new Cliente();
		aux.setCif(cif);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return null;
		else
		return lista.get(pos);
	}
}
	
	

