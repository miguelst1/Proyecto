package com.proyecto.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.proyecto.modelo.OfertaIndividual;
import com.proyecto.repositorio.OfertaIndividualRepositorio;
import com.proyecto.servicio.OfertaIndividualServicio;

import lombok.Getter;
import lombok.Setter;

@Service
@Primary
@Getter
@Setter
public class OfertaIndividualServicioImpl implements OfertaIndividualServicio {

	@Autowired
	private OfertaIndividualRepositorio repositorio;

	@Override
	public void insertOfertaIndividual(OfertaIndividual ofertaIndividual, int idIndividual) {
		repositorio.insertOfertaIndividual(ofertaIndividual, idIndividual);
	}

	@Override
	public OfertaIndividual getOfertaIndividual(int idIndividual, String lenguaje) {
		return repositorio.getOfertaIndividual(idIndividual, lenguaje);
	}

	@Override
	public void updateOfertaIndividual(OfertaIndividual ofertaIndividual) {
		repositorio.updateOfertaIndividual(ofertaIndividual);
	}

	@Override
	public List<OfertaIndividual> getOfertasIndividual() {
		return repositorio.getOfertasIndividual();
	}

	@Override
	public void deleteOfertaIndividual(int idIndividual, String lenguaje) {
		repositorio.deleteOfertaIndividual(idIndividual, lenguaje);
	}
}
