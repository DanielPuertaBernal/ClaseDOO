package co.edu.uco.tiendachepito.business.domain;

import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;

public class CiudadDomain {
	private int id;
	private String nombre;
	private DepartamentoDomain departamento;
	
	private CiudadDomain(final int id, final String nombre, final DepartamentoDomain departamento) {
		setId(id);
		setNombre(nombre);
		setDepartamento(departamento);
	}
	
	private CiudadDomain() {
		setNombre(TextHelper.EMPTY);
		setPais(DepartamentoDomain.crear());
	}
	
	public static final CiudadDomain crear(final int id, final String nombre, final DepartamentoDomain departamento) {
		return new CiudadDomain(id, nombre, departamento);
	}
	
	public static final CiudadDomain crear() {
		return new CiudadDomain();
	}
	
	private final void setId(int id) {
		this.id = id;
	}
	
	private final void setNombre(String nombre) {
		this nombre = TextHelper.applyTrim(nombre);
	}
	
	private final void setDepartamento(final DepartamentoDomain departamento) {
		this.departamento = ObjectHelper
	}
	
	public final int getId() {
		return id;
	}
	
	public final String getNombre() {
		return nombre;
	}
	
	public final DepartamentoDomain getPais() {
		return departamento;
	}
}
