package com.proyecto.modelo;

import lombok.Data;

@Data
public class Individual {

	private int idIndividual;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private String ciudad;
	private String provincia;
	private int telefono;
	private String email;
	private String usuario;
	private String password;

	public Individual() {

	}
}
