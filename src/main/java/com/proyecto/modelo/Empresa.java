package com.proyecto.modelo;

import lombok.Data;

@Data
public class Empresa {

	private int idEmpresa;
	private String nombre;
	private int telefono;
	private String email;
	private String direccion;
	private String usuario;
	private String password;

	public Empresa() {

	}
}
