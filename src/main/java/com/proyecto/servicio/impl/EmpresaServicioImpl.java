package com.proyecto.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.proyecto.modelo.Empresa;
import com.proyecto.repositorio.EmpresaRepositorio;
import com.proyecto.servicio.EmpresaServicio;

import lombok.Getter;
import lombok.Setter;

@Service
@Primary
@Getter
@Setter
public class EmpresaServicioImpl implements EmpresaServicio {

	@Autowired
	private EmpresaRepositorio repositorio;

	@Override
	public void insertEmpresa(Empresa empresa) {
		repositorio.insertEmpresa(empresa);
	}

	@Override
	public Empresa getEmpresa(int idEmpresa) {
		return repositorio.getEmpresa(idEmpresa);
	}

	@Override
	public List<Empresa> getLogin() {
		return repositorio.getLogin();
	}

	@Override
	public void updateEmpresa(Empresa empresa) {
		repositorio.updateEmpresa(empresa);
	}

	@Override
	public List<Empresa> getEmpresas() {
		return repositorio.getEmpresas();
	}

	@Override
	public void deleteEmpresa(int idEmpresa) {
		repositorio.deleteEmpresa(idEmpresa);
	}
}
