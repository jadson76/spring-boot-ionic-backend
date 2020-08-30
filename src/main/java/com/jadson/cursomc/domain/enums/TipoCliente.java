package com.jadson.cursomc.domain.enums;

import net.bytebuddy.implementation.bytecode.Throw;

public enum TipoCliente {
	
	PESSOAFISICA (1, "Pessoa Fisica"),
	PESSOAJURIDICA (2, "Pessoa Juridica");

	private int cod;
	private String desrcicao;
	
	private TipoCliente(int cod, String desrcicao) {
		this.cod = cod;
		this.desrcicao = desrcicao;
	}

	public int getCod() {
		return cod;
	}

	public String getDesrcicao() {
		return desrcicao;
	}

	public static TipoCliente toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
			throw new IllegalArgumentException("Id invalido: "+ cod);
		}
		return null;
	}
	
	
	
}
