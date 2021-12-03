package com.ite.proyectos.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String idProyecto;

	
	private BigDecimal costeReal;

	
	private BigDecimal costesPrevisto;

	private String descripcion;

	private String estado;

	
	private Date fechaFinPrevisto;

	
	private Date fechaFinReal;

	
	private Date fechaInicio;

	//Cantidad de unidades que se pretenden vender?
	private BigDecimal ventaPrevisto;

	
	private List<ProyectoConEmpleado> proyectoConEmpleados;
	
	private List<ProyectoConProducto> proyectoConProducto;

	//Clientes ya previamente existentes!!
	private Cliente cliente;

	//Un empleado con el perfil de jefe de proyecto
	private Empleado jefeProyecto;

	public Proyecto() {
	}
	
	
	


	public Proyecto(String idProyecto, BigDecimal costeReal, BigDecimal costesPrevisto, String descripcion,
			String estado, Date fechaFinPrevisto, Date fechaFinReal, Date fechaInicio, BigDecimal ventaPrevisto,
			List<ProyectoConEmpleado> proyectoConEmpleados, List<ProyectoConProducto> proyectoConProducto,
			Cliente cliente, Empleado jefeProyecto) {
		super();
		this.idProyecto = idProyecto;
		this.costeReal = costeReal;
		this.costesPrevisto = costesPrevisto;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaFinPrevisto = fechaFinPrevisto;
		this.fechaFinReal = fechaFinReal;
		this.fechaInicio = fechaInicio;
		this.ventaPrevisto = ventaPrevisto;
		this.proyectoConEmpleados = proyectoConEmpleados;
		this.proyectoConProducto = proyectoConProducto;
		this.cliente = cliente;
		this.jefeProyecto = jefeProyecto;
	}





	public String getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public BigDecimal getCosteReal() {
		return this.costeReal;
	}

	public void setCosteReal(BigDecimal costeReal) {
		this.costeReal = costeReal;
	}

	public BigDecimal getCostesPrevisto() {
		return this.costesPrevisto;
	}

	public void setCostesPrevisto(BigDecimal costesPrevisto) {
		this.costesPrevisto = costesPrevisto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFinPrevisto() {
		return this.fechaFinPrevisto;
	}

	public void setFechaFinPrevisto(Date fechaFinPrevisto) {
		this.fechaFinPrevisto = fechaFinPrevisto;
	}

	public Date getFechaFinReal() {
		return this.fechaFinReal;
	}

	public void setFechaFinReal(Date fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public BigDecimal getVentaPrevisto() {
		return this.ventaPrevisto;
	}

	public void setVentaPrevisto(BigDecimal ventaPrevisto) {
		this.ventaPrevisto = ventaPrevisto;
	}

	public List<ProyectoConEmpleado> getProyectoConEmpleados() {
		return this.proyectoConEmpleados;
	}

	public void setProyectoConEmpleados(List<ProyectoConEmpleado> proyectoConEmpleados) {
		this.proyectoConEmpleados = proyectoConEmpleados;
	}

	public ProyectoConEmpleado addProyectoConEmpleado(ProyectoConEmpleado proyectoConEmpleado) {
		getProyectoConEmpleados().add(proyectoConEmpleado);
		proyectoConEmpleado.setProyecto(this);

		return proyectoConEmpleado;
	}

	public ProyectoConEmpleado removeProyectoConEmpleado(ProyectoConEmpleado proyectoConEmpleado) {
		getProyectoConEmpleados().remove(proyectoConEmpleado);
		proyectoConEmpleado.setProyecto(null);

		return proyectoConEmpleado;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getJefeProyecto() {
		return this.jefeProyecto;
	}

	public void setJefeProyecto(Empleado jefeProyecto) {
		this.jefeProyecto = jefeProyecto;
	}
	

	public List<ProyectoConProducto> getProyectoConProducto() {
		return proyectoConProducto;
	}
	
	public ProyectoConProducto addProyectoConProducto(ProyectoConProducto proyectoConProducto) {
		getProyectoConProducto().add(proyectoConProducto);
		proyectoConProducto.setProyecto(this);
		
		return proyectoConProducto;
	}
	
	public ProyectoConProducto removeProyectoConProducto(ProyectoConProducto proyectoConProducto) {
		getProyectoConProducto().remove(proyectoConProducto);
		proyectoConProducto.setProducto(null);

		return proyectoConProducto;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProyecto == null) ? 0 : idProyecto.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Proyecto))
			return false;
		Proyecto other = (Proyecto) obj;
		if (idProyecto == null) {
			if (other.idProyecto != null)
				return false;
		} else if (!idProyecto.equals(other.idProyecto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", costeReal=" + costeReal + ", costesPrevisto=" + costesPrevisto
				+ ", descripcion=" + descripcion + ", estado=" + estado + ", fechaFinPrevisto=" + fechaFinPrevisto
				+ ", fechaFinReal=" + fechaFinReal + ", fechaInicio=" + fechaInicio + ", ventaPrevisto=" + ventaPrevisto
				+ ", proyectoConEmpleados=" + proyectoConEmpleados + ", proyectoConProducto=" + proyectoConProducto
				+ ", cliente=" + cliente + ", jefeProyecto=" + jefeProyecto + "]";
	}



	

}