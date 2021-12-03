package Test;


import com.ite.proyecto.modelo.daos.IntProyectoDao;
import com.ite.proyecto.modelo.daos.ProyectoDaoImpl;
import com.ite.proyectos.beans.Proyecto;

public class TestProyecto {

	public static void main(String[] args) {
		IntProyectoDao prof = new ProyectoDaoImpl();
		for (Proyecto cad: prof.findAll())
		System.out.println(cad.toString());
		
		Proyecto cav = new Proyecto("sdad",null,null,null,null,null,null,null,null,null, null, null, null);
		prof.addProyecto(cav);
		for (Proyecto cad: prof.findAll())
			System.out.println(cad.toString());
			System.out.println("======= Proyectos Activos =======");
		for (Proyecto cad: prof.proyectoActivos())
			System.out.println(cad.toString());
	}
}
