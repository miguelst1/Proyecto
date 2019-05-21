package com.proyecto.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.modelo.Empresa;
import com.proyecto.modelo.OfertaEmpresa;
import com.proyecto.servicio.OfertaEmpresaServicio;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "ofertaEmpresaBean")
@SessionScoped
@Component
@Getter
@Setter
public class OfertaEmpresaBean {

	private Empresa empresa;

	private OfertaEmpresa ofertaEmpresa;

	@Autowired
	private OfertaEmpresaServicio servicio;

	private List<OfertaEmpresa> filtroOfertas;

	private List<OfertaEmpresa> ofertasEmpresa;

	public List<OfertaEmpresa> ofertasEmpresaPorId;

	private OfertaEmpresa ofertaSeleccionada;

	public OfertaEmpresaBean() {
		this.ofertaEmpresa = new OfertaEmpresa();
		this.filtroOfertas = new ArrayList<OfertaEmpresa>();
	}

	@PostConstruct
	public void init() {
		this.ofertasEmpresa = this.servicio.getOfertasEmpresa();
	}

	public void insertOfertaEmpresa() throws IOException {
		empresa = (Empresa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empresa");
		this.servicio.insertOfertaEmpresa(this.ofertaEmpresa, this.empresa.getIdEmpresa());
	}

	public void getOfertasEmpresaPorId() {
		empresa = (Empresa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empresa");
		this.ofertasEmpresaPorId = this.servicio.getOfertasEmpresaPorEmpresa(empresa.getIdEmpresa());
	}

	public void aceptar() {
		this.servicio.deleteOfertaEmpresa(this.ofertaSeleccionada.getIdEmpresa(),
				this.ofertaSeleccionada.getLenguaje());
	}

	public void botonAceptar() {
		aceptar();
		init();
	}
}
