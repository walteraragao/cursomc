package com.walter.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walter.cursomc.domain.Categoria;
import com.walter.cursomc.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria buscar(int id) {
		Optional<Categoria> categoria = this.repository.findById(id);
		return categoria.orElse(null);
	}
}
