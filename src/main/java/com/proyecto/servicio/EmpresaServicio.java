package com.proyecto.servicio;

import java.util.List;

import com.proyecto.modelo.Empresa;

public interface EmpresaServicio {

	public void insertEmpresa(Empresa empresa);

	public Empresa getEmpresa(int idEmpresa);

	public List<Empresa> getLogin();

	public void updateEmpresa(Empresa empresa);

	public List<Empresa> getEmpresas();

	public void deleteEmpresa(int idEmpresa);
}
