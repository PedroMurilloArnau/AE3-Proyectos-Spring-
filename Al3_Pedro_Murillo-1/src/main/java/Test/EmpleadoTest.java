package Test;


import com.ite.proyecto.modelo.daos.EmpleadosDaolmpl;
import com.ite.proyecto.modelo.daos.IntEmpleadosDao;
import com.ite.proyectos.beans.Empleado;

public class EmpleadoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntEmpleadosDao edao = new EmpleadosDaolmpl();
		for (Empleado ele: edao.findAll())
			System.out.println(ele);
		System.out.println(edao.findById(3));
	}
		

}
