package com.proyecto.beans;

import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.proyecto.modelo.Empresa;
import com.proyecto.modelo.Individual;

@ManagedBean(name = "comprobarLoginBean")
@ViewScoped
public class ComprobarLoginBean {

	public void verificarLoginIndividual() {
		try {
			Individual usuario = (Individual) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("usuario");

			if (Objects.isNull(usuario)) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("proyectoLogin.xhtml");
			}
		} catch (Exception e) {

		}
	}

	public void verificarLoginEmpresa() {
		try {
			Empresa empresa = (Empresa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("empresa");

			if (Objects.isNull(empresa)) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("proyectoLogin.xhtml");
			}
		} catch (Exception e) {

		}
	}
}
