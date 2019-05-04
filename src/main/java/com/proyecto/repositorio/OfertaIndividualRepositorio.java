package com.proyecto.repositorio;

import java.util.List;

import com.proyecto.modelo.OfertaIndividual;

public interface OfertaIndividualRepositorio {

	public void insertOfertaIndividual(OfertaIndividual ofertaIndividual, int idIndividual);

	public OfertaIndividual getOfertaIndividual(int idIndividual, String lenguaje);

	public void updateOfertaIndividual(OfertaIndividual ofertaIndividual);

	public List<OfertaIndividual> getOfertasIndividual();

	public void deleteOfertaIndividual(int idIndividual, String lenguaje);
}
