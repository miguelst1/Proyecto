package com.proyecto.repositorio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.proyecto.mapper.LenguajeMapper;
import com.proyecto.modelo.Lenguaje;
import com.proyecto.repositorio.LenguajesRepositorio;

import lombok.Getter;
import lombok.Setter;

@Repository
@Primary
@Getter
@Setter
public class LenguajesRepositorioImpl implements LenguajesRepositorio {

	@Autowired
	private LenguajeMapper mapper;

	@Override
	public List<Lenguaje> getLenguajes() {
		return this.mapper.getLenguajes();
	}

}
