package Test;

import com.ite.proyecto.modelo.daos.IntPerfileDao;
import com.ite.proyecto.modelo.daos.PerfilesDaolmpl;
import com.ite.proyectos.beans.Perfile;

public class TestPerfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntPerfileDao perf = new PerfilesDaolmpl();
		for (Perfile cad: perf.findAll())
		System.out.println(cad.toString());
		
	}

}
