package com.tcc.atendimento.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.tcc.atendimento.model.Atendente;

public class Atendentes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	@Inject
	public Atendentes(EntityManager manager){
		this.manager = manager;
	}
	
	//////////////////////////////////////////////////////////
	
	public Atendente porId(Long id){
		return manager.find(Atendente.class, id);
	}
	
	public Atendente guardar(Atendente atendente){
		return this.manager.merge(atendente);
	}
	
	public void remover(Atendente atendente){
		this.manager.remove(atendente);
	}
	
	/////////////////////////////////////////////////////////
	
	public List<Atendente> todos(){
		TypedQuery<Atendente> query = manager.createQuery("from Atendente", Atendente.class);
		
		return query.getResultList();
	}
	public void adicionar(Atendente atendente){
		this.manager.persist(atendente);
		
	}
	

}
