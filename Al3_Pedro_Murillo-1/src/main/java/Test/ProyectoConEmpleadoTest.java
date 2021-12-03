package Test;

import com.ite.proyecto.modelo.daos.IntProyectoConEmpleado;
import com.ite.proyecto.modelo.daos.ProyectoConEmpleadoDaoImpl;
import com.ite.proyectos.beans.ProyectoConEmpleado;

public class ProyectoConEmpleadoTest {

	public static void main(String[] args) {
		
		IntProyectoConEmpleado proye = new ProyectoConEmpleadoDaoImpl();
		
		
		
		for(ProyectoConEmpleado prd: proye.findAll())
			System.out.println(prd);

	}

}
