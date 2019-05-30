package com.proyecto.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.modelo.Empresa;

public interface EmpresaMapper {

	@Transactional
	public void insertEmpresa(@Param("empresa") Empresa empresa);

	@Transactional
	public Empresa getEmpresa(@Param("idEmpresa") int idEmpresa);

	@Transactional
	public List<Empresa> getLogin();

	@Transactional
	public void updateEmpresa(@Param("empresa") Empresa empresa);

	@Transactional
	public List<Empresa> getEmpresas();

	@Transactional
	public void deleteEmpresa(@Param("idEmpresa") int idEmpresa);
}
