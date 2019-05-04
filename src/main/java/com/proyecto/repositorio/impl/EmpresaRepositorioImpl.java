package com.proyecto.repositorio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.proyecto.mapper.EmpresaMapper;
import com.proyecto.modelo.Empresa;
import com.proyecto.repositorio.EmpresaRepositorio;

import lombok.Getter;
import lombok.Setter;

@Repository
@Primary
@Getter
@Setter
public class EmpresaRepositorioImpl implements EmpresaRepositorio {

	@Autowired
	private EmpresaMapper mapper;

	@Override
	public void insertEmpresa(Empresa empresa) {
		mapper.insertEmpresa(empresa);
	}

	@Override
	public Empresa getEmpresa(int idEmpresa) {
		return mapper.getEmpresa(idEmpresa);
	}

	@Override
	public List<Empresa> getLogin() {
		return mapper.getLogin();
	}

	@Override
	public void updateEmpresa(Empresa empresa) {
		mapper.updateEmpresa(empresa);
	}

	@Override
	public List<Empresa> getEmpresas() {
		return mapper.getEmpresas();
	}

	@Override
	public void deleteEmpresa(int idEmpresa) {
		mapper.deleteEmpresa(idEmpresa);
	}

}
