package com.proyecto.beans;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.modelo.Individual;
import com.proyecto.servicio.IndividualServicio;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "individualBean")
@SessionScoped
@Component
@Getter
@Setter
public class IndividualBean {

	private Individual individual;

	@Autowired
	private IndividualServicio servicio;

	public IndividualBean() {
		this.individual = new Individual();
	}

	public void registrarse() throws IOException {
		this.servicio.insertIndividual(this.individual);

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.individual);

		FacesContext.getCurrentInstance().getExternalContext().redirect("verOfertasEmpresa.xhtml");
	}

	public void comprobarLogin() throws IOException {
		List<Individual> usuarios = this.servicio.getLogin();

		if (!usuarios.isEmpty() && Objects.nonNull(usuarios)
				&& usuarios.stream().map(Individual::getUsuario).collect(Collectors.toList())
						.contains(this.individual.getUsuario())
				&& usuarios.stream().map(Individual::getPassword).collect(Collectors.toList())
						.contains(this.individual.getPassword())) {
			List<Individual> usuario = usuarios.stream()
					.filter(p -> p.getUsuario().equals(this.individual.getUsuario())).collect(Collectors.toList());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario.get(0));
			FacesContext.getCurrentInstance().getExternalContext().redirect("realizarPropuestaIndividual.xhtml");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Credenciales no válidas"));
			FacesContext.getCurrentInstance().getExternalContext().redirect("proyectoLogin.xhtml");
		}
	}

	public void cerrarSesion() {
		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("usuario")) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("proyectoLogin.xhtml");
			} catch (IOException e) {
			}
		}
	}

	public void updateIndividual() {
		this.servicio.updateIndividual(this.individual);
	}
}
