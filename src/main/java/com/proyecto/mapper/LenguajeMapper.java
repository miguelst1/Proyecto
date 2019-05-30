package com.proyecto.mapper;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.proyecto.modelo.Lenguaje;

public interface LenguajeMapper {

	@Transactional
	public List<Lenguaje> getLenguajes();
}
