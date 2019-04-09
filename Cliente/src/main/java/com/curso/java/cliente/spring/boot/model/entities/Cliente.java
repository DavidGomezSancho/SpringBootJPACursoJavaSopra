package com.curso.java.cliente.spring.boot.model.entities;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
	@Id
	private String matricula;
	private String nombre;
	private String apellidos;
	private String direccion;
	
	
	public String getMatricula() {
		return matricula;
	}
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cliente(String matricula, String nombre, String apellidos, String direccion) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
