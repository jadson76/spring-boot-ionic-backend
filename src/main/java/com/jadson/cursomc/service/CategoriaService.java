package com.jadson.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jadson.cursomc.domain.Categoria;
import com.jadson.cursomc.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository; 

	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElse(null);		
		
	}
}
