package com.example.libros.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.libros.entidad.Categoria;

@Service
public class ServicioCategorias {

	public Categoria[] obtenerCategorias() {
		return Categoria.values();
	}
	

}
