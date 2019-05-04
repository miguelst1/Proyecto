package com.proyecto.beans;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.modelo.Empresa;
import com.proyecto.servicio.EmpresaServicio;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "empresaBean")
@ViewScoped
@Component
@Getter
@Setter
public class EmpresaBean {

	private Empresa empresa;

	@Autowired
	private EmpresaServicio servicio;

	public EmpresaBean() {
		this.empresa = new Empresa();
	}

	public void registrarse() throws IOException {
		this.servicio.insertEmpresa(this.empresa);

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empresa", this.empresa);

		FacesContext.getCurrentInstance().getExternalContext().redirect("verOfertasIndividual.xhtml");
	}

	public void comprobarLogin() throws IOException {
		List<Empresa> empresas = this.servicio.getLogin();

		if (!empresas.isEmpty() && Objects.nonNull(empresas)
				&& empresas.stream().map(Empresa::getUsuario).collect(Collectors.toList())
						.contains(this.empresa.getUsuario())
				&& empresas.stream().map(Empresa::getPassword).collect(Collectors.toList())
						.contains(this.empresa.getPassword())) {
			List<Empresa> empresa = empresas.stream().filter(p -> p.getUsuario().equals(this.empresa.getUsuario()))
					.collect(Collectors.toList());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empresa", empresa.get(0));
			FacesContext.getCurrentInstance().getExternalContext().redirect("realizarPropuestaEmpresa.xhtml");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Credenciales no válidas"));
			FacesContext.getCurrentInstance().getExternalContext().redirect("proyectoLogin.xhtml");
		}
	}

	public void cerrarSesion() {
		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("empresa")) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("empresa");
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("proyectoLogin.xhtml");
			} catch (IOException e) {
			}
		}
	}

	public void updateEmpresa() {
		this.servicio.updateEmpresa(this.empresa);
	}
}
