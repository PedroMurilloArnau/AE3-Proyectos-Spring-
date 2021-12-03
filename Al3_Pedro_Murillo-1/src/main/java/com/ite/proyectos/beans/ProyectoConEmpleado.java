package com.ite.proyectos.beans;

import java.io.Serializable;
import java.util.Date;

//Asignación de un Empleado a un proyecto
public class ProyectoConEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	private int numeroOrden;

	private Date fechaIncorporacion;

	private int horasAsignadas;

	
	private Empleado empleado;

	private Proyecto proyecto;

	public ProyectoConEmpleado() {
	}
	

	public ProyectoConEmpleado(int numeroOrden, Date fechaIncorporacion, int horasAsignadas, Empleado empleado,
			Proyecto proyecto) {
		super();
		this.numeroOrden = numeroOrden;
		this.fechaIncorporacion = fechaIncorporacion;
		this.horasAsignadas = horasAsignadas;
		this.empleado = empleado;
		this.proyecto = proyecto;
	}


	public int getNumeroOrden() {
		return this.numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public Date getFechaIncorporacion() {
		return this.fechaIncorporacion;
	}

	public void setFechaIncorporacion(Date fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}

	public int getHorasAsignadas() {
		return this.horasAsignadas;
	}

	public void setHorasAsignadas(int horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroOrden;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ProyectoConEmpleado))
			return false;
		ProyectoConEmpleado other = (ProyectoConEmpleado) obj;
		if (numeroOrden != other.numeroOrden)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ProyectoConEmpleado [numeroOrden=" + numeroOrden + ", fechaIncorporacion=" + fechaIncorporacion
				+ ", horasAsignadas=" + horasAsignadas + ", empleado=" + empleado + ", proyecto=" + proyecto + "]";
	}
	
}