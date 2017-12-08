package com.tcc.atendimento.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.tcc.atendimento.model.Atendente;
import com.tcc.atendimento.repository.Atendentes;
import com.tcc.atendimento.util.Transactional;

public class CadastroAtendente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private Atendentes atendentes;


	@Transactional
	public void salvar(Atendente atendente){
		this.atendentes.guardar(atendente);
	}
	@Transactional
	public void excluir(Atendente atendente) throws NegocioException{
		atendente = this.atendentes.porId(atendente.getId());
		this.atendentes.remover(atendente);
	}
}
