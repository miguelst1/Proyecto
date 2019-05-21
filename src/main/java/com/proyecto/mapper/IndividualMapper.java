package com.proyecto.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.modelo.Individual;

public interface IndividualMapper {

	@Transactional
	public void insertIndividual(@Param("individual") Individual individual);

	@Transactional
	public Individual getIndividual(int idIndividual);

	@Transactional
	public List<Individual> getLogin();

	@Transactional
	public void updateIndividual(@Param("individual") Individual individual);

	@Transactional
	public List<Individual> getIndividuales();

	@Transactional
	public void deleteIndividual(@Param("idIndividual") int idIndividual);
}
