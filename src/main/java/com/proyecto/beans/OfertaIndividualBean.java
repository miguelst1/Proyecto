package com.proyecto.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.modelo.Empresa;
import com.proyecto.modelo.Individual;
import com.proyecto.modelo.OfertaIndividual;
import com.proyecto.servicio.IndividualServicio;
import com.proyecto.servicio.LenguajesServicio;
import com.proyecto.servicio.OfertaEmpresaServicio;
import com.proyecto.servicio.OfertaIndividualServicio;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "ofertaIndividualBean")
@SessionScoped
@Component
@Getter
@Setter
public class OfertaIndividualBean {

	private Empresa empresa;

	private Individual individual;

	private Individual individualNombre;

	private OfertaIndividual ofertaIndividual;

	private List<OfertaIndividual> ofertasIndividual;

	private List<OfertaIndividual> ofertasIndividualPorId;

	private List<OfertaIndividual> filtroOfertas;

	private List<String> lenguajes;

	private List<String> listaLenguajes;

	private OfertaIndividual ofertaSeleccionada;

	private Map<Integer, String> nombres;

	@Autowired
	private OfertaIndividualServicio servicio;

	@Autowired
	private IndividualServicio servicioIndividual;

	@Autowired
	private LenguajesServicio servicioLenguajes;

	@Autowired
	private OfertaEmpresaServicio servicioOfertaEmpresa;

	public OfertaIndividualBean() {
		this.ofertaIndividual = new OfertaIndividual();
		this.ofertasIndividualPorId = new ArrayList<OfertaIndividual>();
		this.filtroOfertas = new ArrayList<OfertaIndividual>();
		this.ofertaSeleccionada = new OfertaIndividual();
		this.individualNombre = new Individual();
		this.nombres = new HashMap<Integer, String>();
	}

	public void cargarOfertasIndividual() {
		this.ofertasIndividual = this.servicio.getOfertasIndividual();
	}

	public void insertOfertaIndividual() {
		try {
			individual = (Individual) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("usuario");
			this.servicio.insertOfertaIndividual(this.ofertaIndividual, individual.getIdIndividual());
			FacesContext.getCurrentInstance().addMessage("propuestaIndividualCorrecta", new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Error", "La propuesta se ha realizado correctamente"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("propuestaIndividualIncorrecta",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se ha podido realizar la propuesta"));
		}
	}

	public void obtenerOfertasIndividualPorId() {
		individual = (Individual) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		this.ofertasIndividualPorId = this.servicio.getOfertasIndividualPorIndividual(individual.getIdIndividual());
	}

	public void obtenerLenguajes() {
		this.lenguajes = this.servicioLenguajes.getLenguajes().stream().map(l -> l.getId())
				.collect(Collectors.toList());
	}

	public void aceptar() {
		this.servicio.deleteOfertaIndividual(this.ofertaSeleccionada.getIdIndividual(),
				this.ofertaSeleccionada.getLenguaje());
	}

	public void botonAceptar() {
		aceptar();
		obtenerLenguajesPropuestaEmpresa();
	}

	public void botonEliminar() {
		aceptar();
		cargarOfertasIndividual();
	}

	public void limpiarOferta() {
		this.ofertaIndividual = new OfertaIndividual();
	}

	public void obtenerLenguajesPropuestaEmpresa() {
		this.empresa = (Empresa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empresa");

		this.listaLenguajes = this.servicioOfertaEmpresa.getOfertasEmpresaPorEmpresa(this.empresa.getIdEmpresa())
				.stream().map(o -> o.getLenguaje()).collect(Collectors.toList());

		this.ofertasIndividual = this.servicio.getOfertasIndividual().stream()
				.filter(o -> this.listaLenguajes.contains(o.getLenguaje())).collect(Collectors.toList());
	}

	public void obtenerNombres() {
		this.ofertasIndividual.stream().map(o -> o.getIdIndividual()).distinct()
				.forEach(i -> this.nombres.put(i,
						this.servicioIndividual.getIndividual(i).getNombre() + " "
								+ this.servicioIndividual.getIndividual(i).getApellido1() + " "
								+ this.servicioIndividual.getIndividual(i).getApellido2()));
		;
	}

	public String obtenerNombre(int idIndividual) {
		return this.nombres.get(idIndividual);
	}
}
