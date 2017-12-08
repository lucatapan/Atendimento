package com.tcc.atendimento.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.tcc.atendimento.model.Escola;

public class Escolas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	@Inject
	public Escolas(EntityManager manager){
		this.manager = manager;
	}
	
	public void remover(Escola escola){
		this.manager.remove(escola);
	}
	
	public Escola porId(Long id){
		return manager.find(Escola.class, id);
	}
	
	public Escola guardar(Escola escola){
		return this.manager.merge(escola);
	}
	
	
	public List<Escola> todos(){
		TypedQuery<Escola> query = manager.createQuery("from Escola", Escola.class);
		return query.getResultList();
	}
	
	public void adicionar(Escola escola){
		this.manager.persist(escola);
		}
}
