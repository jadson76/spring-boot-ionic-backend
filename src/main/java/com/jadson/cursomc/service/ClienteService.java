package com.jadson.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jadson.cursomc.domain.Cliente;
import com.jadson.cursomc.repository.ClienteRepository;

@Service 
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElse(null);		
		
	}

}
