package com.tcc.atendimento.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.tcc.atendimento.model.Pendencia;
import com.tcc.atendimento.repository.Pendencias;
import com.tcc.atendimento.util.Transactional;

public class CadastroPendencia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private Pendencias pendencias;
	
	@Transactional
	public void salvar(Pendencia pendencia) throws NegocioException{
		this.pendencias.guardar(pendencia);
		
	}
	
	@Transactional
	public void excluir(Pendencia pendencia) throws NegocioException{
		pendencia = this.pendencias.porId(pendencia.getId());
		this.pendencias.remover(pendencia);
	}

}
