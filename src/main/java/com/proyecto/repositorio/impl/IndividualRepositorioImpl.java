package com.proyecto.repositorio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.proyecto.mapper.IndividualMapper;
import com.proyecto.modelo.Individual;
import com.proyecto.repositorio.IndividualRepositorio;

import lombok.Getter;
import lombok.Setter;

@Repository
@Primary
@Getter
@Setter
public class IndividualRepositorioImpl implements IndividualRepositorio {

	@Autowired
	private IndividualMapper mapper;

	@Override
	public void insertIndividual(Individual individual) {
		mapper.insertIndividual(individual);
	}

	@Override
	public Individual getIndividual(int idIndividual) {
		return mapper.getIndividual(idIndividual);
	}

	@Override
	public void updateIndividual(Individual individual) {
		mapper.updateIndividual(individual);
	}

	@Override
	public List<Individual> getIndividuales() {
		return mapper.getIndividuales();
	}

	@Override
	public void deleteIndividual(int idIndividual) {
		mapper.deleteIndividual(idIndividual);
	}

	@Override
	public List<Individual> getLogin() {
		return mapper.getLogin();
	}

}
