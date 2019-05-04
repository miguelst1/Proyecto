package com.proyecto.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.proyecto.modelo.Individual;
import com.proyecto.repositorio.IndividualRepositorio;
import com.proyecto.servicio.IndividualServicio;

import lombok.Getter;
import lombok.Setter;

@Service
@Primary
@Getter
@Setter
public class IndividualServicioImpl implements IndividualServicio {

	@Autowired
	private IndividualRepositorio repositorio;

	@Override
	public void insertIndividual(Individual individual) {
		repositorio.insertIndividual(individual);
	}

	@Override
	public Individual getIndividual(int idIndividual) {
		return repositorio.getIndividual(idIndividual);
	}

	@Override
	public void updateIndividual(Individual individual) {
		repositorio.updateIndividual(individual);
	}

	@Override
	public List<Individual> getIndividuales() {
		return repositorio.getIndividuales();
	}

	@Override
	public void deleteIndividual(int idIndividual) {
		repositorio.deleteIndividual(idIndividual);
	}

	@Override
	public List<Individual> getLogin() {
		return repositorio.getLogin();
	}

}
