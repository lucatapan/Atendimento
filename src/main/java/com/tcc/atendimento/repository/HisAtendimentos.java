package com.tcc.atendimento.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.tcc.atendimento.model.HisAtendimento;

public class HisAtendimentos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	
	@Inject
	public HisAtendimentos (EntityManager manager){
		this.manager = manager;
	}
	
	public HisAtendimento porId(Long id){
		return manager.find(HisAtendimento.class, id);
	}
	
	public HisAtendimento guardar(HisAtendimento hisAtendimento){
		return this.manager.merge(hisAtendimento);
	}
	
	public void remover(HisAtendimento hisAtendimento){
		this.manager.remove(hisAtendimento);
	}
	
	public List<HisAtendimento> todos(){
		TypedQuery<HisAtendimento> query = manager.createQuery("from HisAtendimento", HisAtendimento.class);
		return query.getResultList();
	}
	
	public void adicionar(HisAtendimento hisAtendimento){
		this.manager.persist(hisAtendimento);
	}
}
