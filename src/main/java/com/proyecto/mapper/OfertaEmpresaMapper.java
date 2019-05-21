package com.proyecto.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.modelo.OfertaEmpresa;

public interface OfertaEmpresaMapper {

	@Transactional
	public void insertOfertaEmpresa(@Param("ofertaEmpresa") OfertaEmpresa ofertaEmpresa,
			@Param("idEmpresa") int idEmpresa);

	@Transactional
	public OfertaEmpresa getOfertaEmpresa(int idEmpresa, String lenguaje);

	@Transactional
	public void updateOfertaEmpresa(@Param("ofertaEmpresa") OfertaEmpresa ofertaEmpresa);

	@Transactional
	public List<OfertaEmpresa> getOfertasEmpresa();

	@Transactional
	public List<OfertaEmpresa> getOfertasEmpresaPorEmpresa(@Param("idEmpresa") int idEmpresa);

	@Transactional
	public void deleteOfertaEmpresa(@Param("idEmpresa") int idEmpresa, @Param("lenguaje") String lenguaje);
}
