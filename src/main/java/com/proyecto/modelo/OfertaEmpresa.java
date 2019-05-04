package com.proyecto.modelo;

import lombok.Data;

@Data
public class OfertaEmpresa {

	private int idEmpresa;
	private String lenguaje;
	private String descripcion;
	private int sueldo;
	private int experiencia;
	private String horario;

	public OfertaEmpresa() {

	}
}
