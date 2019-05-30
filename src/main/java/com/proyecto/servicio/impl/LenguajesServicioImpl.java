package com.proyecto.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.proyecto.modelo.Lenguaje;
import com.proyecto.repositorio.LenguajesRepositorio;
import com.proyecto.servicio.LenguajesServicio;

import lombok.Getter;
import lombok.Setter;

@Service
@Primary
@Getter
@Setter
public class LenguajesServicioImpl implements LenguajesServicio {

	@Autowired
	private LenguajesRepositorio repositorio;

	@Override
	public List<Lenguaje> getLenguajes() {
		return this.repositorio.getLenguajes();
	}

}
