package com.proyecto.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.modelo.Individual;
import com.proyecto.modelo.OfertaIndividual;
import com.proyecto.servicio.OfertaIndividualServicio;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "ofertaIndividualBean")
@SessionScoped
@Component
@Getter
@Setter
public class OfertaIndividualBean {

	private Individual individual;

	private OfertaIndividual ofertaIndividual;

	private List<OfertaIndividual> ofertasIndividual;

	private List<OfertaIndividual> ofertasIndividualPorId;

	private List<OfertaIndividual> filtroOfertas;

	private OfertaIndividual ofertaSeleccionada;

	@Autowired
	private OfertaIndividualServicio servicio;

	public OfertaIndividualBean() {
		this.ofertaIndividual = new OfertaIndividual();
		this.ofertasIndividualPorId = new ArrayList<OfertaIndividual>();
		this.filtroOfertas = new ArrayList<OfertaIndividual>();
		this.ofertaSeleccionada = new OfertaIndividual();
	}

	@PostConstruct
	public void init() {
		this.ofertasIndividual = this.servicio.getOfertasIndividual();
	}

	public void insertOfertaIndividual() {
		individual = (Individual) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		this.servicio.insertOfertaIndividual(this.ofertaIndividual, individual.getIdIndividual());
	}

	public void obtenerOfertasIndividualPorId() {
		individual = (Individual) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		this.ofertasIndividualPorId = this.servicio.getOfertasIndividualPorIndividual(individual.getIdIndividual());
	}

	public void aceptar() {
		this.servicio.deleteOfertaIndividual(this.ofertaSeleccionada.getIdIndividual(),
				this.ofertaSeleccionada.getLenguaje());
	}

	public void botonAceptar() {
		aceptar();
		init();
	}
}
