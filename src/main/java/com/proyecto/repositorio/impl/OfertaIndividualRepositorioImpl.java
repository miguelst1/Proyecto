package com.proyecto.repositorio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.proyecto.mapper.OfertaIndividualMapper;
import com.proyecto.modelo.OfertaIndividual;
import com.proyecto.repositorio.OfertaIndividualRepositorio;

import lombok.Getter;
import lombok.Setter;

@Repository
@Primary
@Getter
@Setter
public class OfertaIndividualRepositorioImpl implements OfertaIndividualRepositorio {

	@Autowired
	private OfertaIndividualMapper mapper;

	@Override
	public void insertOfertaIndividual(OfertaIndividual ofertaIndividual, int idIndividual) {
		mapper.insertOfertaIndividual(ofertaIndividual, idIndividual);
	}

	@Override
	public OfertaIndividual getOfertaIndividual(int idIndividual, String lenguaje) {
		return mapper.getOfertaIndividual(idIndividual, lenguaje);
	}

	@Override
	public void updateOfertaIndividual(OfertaIndividual ofertaIndividual) {
		mapper.updateOfertaIndividual(ofertaIndividual);
	}

	@Override
	public List<OfertaIndividual> getOfertasIndividual() {
		return mapper.getOfertasIndividual();
	}

	@Override
	public void deleteOfertaIndividual(int idIndividual, String lenguaje) {
		mapper.deleteOfertaIndividual(idIndividual, lenguaje);
	}

}
