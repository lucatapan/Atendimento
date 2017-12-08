package com.tcc.atendimento.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.tcc.atendimento.model.HisAtendimento;
import com.tcc.atendimento.repository.HisAtendimentos;
import com.tcc.atendimento.util.Transactional;

public class CadastroHisAtendimento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private HisAtendimentos hisAtendimentos;
	
	
	@Transactional
	public void salvar(HisAtendimento hisAtendimento) throws NegocioException{
		if(hisAtendimento.getData() != null && hisAtendimento.getData().after(new Date())){
			throw new NegocioException(
				"Data do histórico não pode ser uma data futura.");
			}
		this.hisAtendimentos.guardar(hisAtendimento);
		}
	
	@Transactional
	public void excluir(HisAtendimento hisAtendimento) throws NegocioException{
		hisAtendimento = this.hisAtendimentos.porId(hisAtendimento.getId());
		this.hisAtendimentos.remover(hisAtendimento);
	}
	
	}
	
	

