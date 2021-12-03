package Test;

import java.math.BigDecimal;

import com.ite.proyecto.modelo.daos.ClienteDaoImpl;
import com.ite.proyecto.modelo.daos.IntClienteDao;
import com.ite.proyectos.beans.Cliente;


public class ClienteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("------------Prueba findAll---------------");
		IntClienteDao edao = new ClienteDaoImpl();
		for (Cliente ele: edao.findAll())
			System.out.println(ele.getNombre());
		
		System.out.println("------------Prueba findByCif---------------");
		System.out.println(edao.findByCif("50900628L").getNombre());
		
		System.out.println("------------Prueba Añadir nuevo Cliente---------------");
		Cliente cuf = new Cliente("4846546G","C/benjamin",new BigDecimal("900.000"),"Marta",0);
		edao.addCliente(cuf);
		for (Cliente ele: edao.findAll())
			System.out.println(ele.getNombre());
	}
}


