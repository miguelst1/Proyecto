package com.proyecto.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.modelo.OfertaIndividual;

public interface OfertaIndividualMapper {

	@Transactional
	public void insertOfertaIndividual(@Param("ofertaIndividual") OfertaIndividual ofertaIndividual,
			@Param("idIndividual") int idIndividual);

	@Transactional
	public OfertaIndividual getOfertaIndividual(int idIndividual, String lenguaje);

	@Transactional
	public void updateOfertaIndividual(@Param("ofertaIndividual") OfertaIndividual ofertaIndividual);

	@Transactional
	public List<OfertaIndividual> getOfertasIndividual();

	@Transactional
	public void deleteOfertaIndividual(int idIndividual, String lenguaje);
}
