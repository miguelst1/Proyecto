package com.proyecto.servicio;

import java.util.List;

import com.proyecto.modelo.OfertaIndividual;

public interface OfertaIndividualServicio {

	public void insertOfertaIndividual(OfertaIndividual ofertaIndividual, int idIndividual);

	public OfertaIndividual getOfertaIndividual(int idIndividual, String lenguaje);

	public void updateOfertaIndividual(OfertaIndividual ofertaIndividual);

	public List<OfertaIndividual> getOfertasIndividual();

	public List<OfertaIndividual> getOfertasIndividualPorIndividual(int idIndividual);

	public void deleteOfertaIndividual(int idIndividual, String lenguaje);
}
