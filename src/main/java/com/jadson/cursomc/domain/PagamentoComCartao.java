package com.jadson.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import com.jadson.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento implements Serializable{


	private static final long serialVersionUID = -6253501013584093332L;
	
	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;	
		
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
	

}
