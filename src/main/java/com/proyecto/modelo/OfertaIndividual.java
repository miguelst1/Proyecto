package com.proyecto.modelo;

import lombok.Data;

@Data
public class OfertaIndividual {

	private int idIndividual;
	private String lenguaje;
	private String nivel;
	private int experiencia;
	private String descripcion;

	public OfertaIndividual() {

	}
}
