package Test;

import java.math.BigDecimal;

import com.ite.proyecto.modelo.daos.IntProducto;
import com.ite.proyecto.modelo.daos.IntProyectoConProducto;
import com.ite.proyecto.modelo.daos.IntProyectoDao;
import com.ite.proyecto.modelo.daos.ProductoDaoImpl;
import com.ite.proyecto.modelo.daos.ProyectoConProductoDaoImpl;
import com.ite.proyecto.modelo.daos.ProyectoDaoImpl;
import com.ite.proyectos.beans.ProyectoConProducto;

public class ProyectoConProductoTest {

	public static void main(String[] args) {
		
		IntProyectoConProducto proyp = new ProyectoConProductoDaoImpl();
		IntProducto produc = new ProductoDaoImpl();
		IntProyectoDao prot = new ProyectoDaoImpl();
		for(ProyectoConProducto prd: proyp.findAll())
			System.out.println(prd);
			System.out.println("-----------Pruebaas Add ProyectoConProducto--------");
		ProyectoConProducto prd = new ProyectoConProducto(0,3,new BigDecimal("45"), produc.findByIdProducto(1), prot.findByidProyecto("1por"));
		proyp.addProyectoConProducto(prd);
		for(ProyectoConProducto prdt: proyp.findAll())
			System.out.println(prdt);

	}

}
