package com.proyecto.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.modelo.Empresa;

public interface EmpresaMapper {

	public void insertEmpresa(@Param("empresa") Empresa empresa);

	@Transactional
	public Empresa getEmpresa(int idEmpresa);

	@Transactional
	public List<Empresa> getLogin();

	@Transactional
	public void updateEmpresa(@Param("empreas") Empresa empresa);

	@Transactional
	public List<Empresa> getEmpresas();

	@Transactional
	public void deleteEmpresa(int idEmpresa);
}
