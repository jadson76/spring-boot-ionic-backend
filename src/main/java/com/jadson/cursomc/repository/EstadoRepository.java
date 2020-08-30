package com.jadson.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jadson.cursomc.domain.Estado;
import com.jadson.cursomc.domain.Produto;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
