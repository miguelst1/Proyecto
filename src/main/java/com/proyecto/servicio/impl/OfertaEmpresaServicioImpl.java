package com.proyecto.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.proyecto.modelo.OfertaEmpresa;
import com.proyecto.repositorio.OfertaEmpresaRepositorio;
import com.proyecto.servicio.OfertaEmpresaServicio;

import lombok.Getter;
import lombok.Setter;

@Service
@Primary
@Getter
@Setter
public class OfertaEmpresaServicioImpl implements OfertaEmpresaServicio {

	@Autowired
	private OfertaEmpresaRepositorio repositorio;

	@Override
	public void insertOfertaEmpresa(OfertaEmpresa ofertaEmpresa, int idEmpresa) {
		repositorio.insertOfertaEmpresa(ofertaEmpresa, idEmpresa);
	}

	@Override
	public OfertaEmpresa getOfertaEmpresa(int idEmpresa, String lenguaje) {
		return repositorio.getOfertaEmpresa(idEmpresa, lenguaje);
	}

	@Override
	public void updateOfertaEmpresa(OfertaEmpresa ofertaEmpresa) {
		repositorio.updateOfertaEmpresa(ofertaEmpresa);
	}

	@Override
	public List<OfertaEmpresa> getOfertasEmpresa() {
		return repositorio.getOfertasEmpresa();
	}

	@Override
	public void deleteOfertaEmpresa(int idEmpresa, String lenguaje) {
		repositorio.deleteOfertaEmpresa(idEmpresa, lenguaje);
	}

	@Override
	public List<OfertaEmpresa> getOfertasEmpresaPorEmpresa(int idEmpresa) {
		return repositorio.getOfertasEmpresaPorEmpresa(idEmpresa);
	}
}
