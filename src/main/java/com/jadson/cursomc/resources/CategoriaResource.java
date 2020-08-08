package com.jadson.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jadson.cursomc.domain.Categoria;
import com.jadson.cursomc.service.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria>  listar() {
		Categoria cat1 = new Categoria(1, "Informatica");
		Categoria cat2 = new Categoria(2, "Escritorio");
		
		List<Categoria> catList = new ArrayList<Categoria>();
		catList.add(cat1);
		catList.add(cat2);
		
		return catList;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>  find(@PathVariable Integer id) {
		Categoria cat = service.buscar(id);
		return ResponseEntity.ok().body(cat);
		
		
	}

}
