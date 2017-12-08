package com.tcc.atendimento.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.tcc.atendimento.model.Escola;
import com.tcc.atendimento.repository.Escolas;
import com.tcc.atendimento.util.Transactional;

public class CadastroEscola implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Escolas escolas;
	
	@Transactional
	public void salvar(Escola escola) throws NegocioException{
		this.escolas.guardar(escola);
	}
	
	@Transactional
	public void excluir(Escola escola) throws NegocioException{
		escola = this.escolas.porId(escola.getId());
		this.escolas.remover(escola);
	}
}
