package com.proyecto.repositorio;

import java.util.List;

import com.proyecto.modelo.Individual;

public interface IndividualRepositorio {

	public void insertIndividual(Individual individual);

	public Individual getIndividual(int idIndividual);

	public List<Individual> getLogin();

	public void updateIndividual(Individual individual);

	public List<Individual> getIndividuales();

	public void deleteIndividual(int idIndividual);
}
