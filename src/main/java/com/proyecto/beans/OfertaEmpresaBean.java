package com.proyecto.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.modelo.Empresa;
import com.proyecto.modelo.OfertaEmpresa;
import com.proyecto.servicio.EmpresaServicio;
import com.proyecto.servicio.LenguajesServicio;
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

	@Autowired
	private EmpresaServicio servicioEmpresa;

	@Autowired
	private LenguajesServicio servicioLenguajes;

	private List<OfertaEmpresa> filtroOfertas;

	private List<OfertaEmpresa> ofertasEmpresa;

	private List<OfertaEmpresa> ofertasEmpresaPorId;

	private List<String> lenguajes;

	private OfertaEmpresa ofertaSeleccionada;

	private Map<Integer, String> nombres;

	public OfertaEmpresaBean() {
		this.ofertaEmpresa = new OfertaEmpresa();
		this.filtroOfertas = new ArrayList<OfertaEmpresa>();
		this.ofertasEmpresaPorId = new ArrayList<OfertaEmpresa>();
		this.nombres = new HashMap<Integer, String>();
	}

	@PostConstruct
	public void init() {
		this.ofertasEmpresa = this.servicio.getOfertasEmpresa();
	}

	public void insertOfertaEmpresa() throws IOException {
		empresa = (Empresa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empresa");
		this.servicio.insertOfertaEmpresa(this.ofertaEmpresa, this.empresa.getIdEmpresa());
	}

	public void obtenerOfertasEmpresaPorId() {
		empresa = (Empresa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empresa");
		this.ofertasEmpresaPorId = this.servicio.getOfertasEmpresaPorEmpresa(empresa.getIdEmpresa());
	}

	public void obtenerLenguajes() {
		this.lenguajes = this.servicioLenguajes.getLenguajes().stream().map(l -> l.getId())
				.collect(Collectors.toList());
	}

	public void aceptar() {
		this.servicio.deleteOfertaEmpresa(this.ofertaSeleccionada.getIdEmpresa(),
				this.ofertaSeleccionada.getLenguaje());
	}

	public void botonAceptar() {
		aceptar();
		init();
	}

	public void limpiarOfertaEmpresa() {
		this.ofertaEmpresa = new OfertaEmpresa();
	}

	public void cargarOfertas() {
		init();
	}

	public void obtenerNombres() {
		this.ofertasEmpresa.stream().map(o -> o.getIdEmpresa()).distinct()
				.forEach(i -> this.nombres.put(i, this.servicioEmpresa.getEmpresa(i).getNombre()));
		;
	}

	public String obtenerNombre(int idIndividual) {
		return this.nombres.get(idIndividual);
	}
}
