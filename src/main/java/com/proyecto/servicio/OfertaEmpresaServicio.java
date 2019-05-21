package com.proyecto.servicio;

import java.util.List;

import com.proyecto.modelo.OfertaEmpresa;

public interface OfertaEmpresaServicio {

	public void insertOfertaEmpresa(OfertaEmpresa ofertaEmpresa, int idEmpresa);

	public OfertaEmpresa getOfertaEmpresa(int idEmpresa, String lenguaje);

	public void updateOfertaEmpresa(OfertaEmpresa ofertaEmpresa);

	public List<OfertaEmpresa> getOfertasEmpresa();

	public List<OfertaEmpresa> getOfertasEmpresaPorEmpresa(int idEmpresa);

	public void deleteOfertaEmpresa(int idEmpresa, String lenguaje);
}
