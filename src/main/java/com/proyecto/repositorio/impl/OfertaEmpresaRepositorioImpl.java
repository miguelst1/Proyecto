package com.proyecto.repositorio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.proyecto.mapper.OfertaEmpresaMapper;
import com.proyecto.modelo.OfertaEmpresa;
import com.proyecto.repositorio.OfertaEmpresaRepositorio;

import lombok.Getter;
import lombok.Setter;

@Repository
@Primary
@Getter
@Setter
public class OfertaEmpresaRepositorioImpl implements OfertaEmpresaRepositorio {

	@Autowired
	private OfertaEmpresaMapper mapper;

	@Override
	public void insertOfertaEmpresa(OfertaEmpresa ofertaEmpresa, int idEmpresa) {
		mapper.insertOfertaEmpresa(ofertaEmpresa, idEmpresa);
	}

	@Override
	public OfertaEmpresa getOfertaEmpresa(int idEmpresa, String lenguaje) {
		return mapper.getOfertaEmpresa(idEmpresa, lenguaje);
	}

	@Override
	public void updateOfertaEmpresa(OfertaEmpresa ofertaEmpresa) {
		mapper.updateOfertaEmpresa(ofertaEmpresa);
	}

	@Override
	public List<OfertaEmpresa> getOfertasEmpresa() {
		return mapper.getOfertasEmpresa();
	}

	@Override
	public void deleteOfertaEmpresa(int idEmpresa, String lenguaje) {
		mapper.deleteOfertaEmpresa(idEmpresa, lenguaje);
	}

}
