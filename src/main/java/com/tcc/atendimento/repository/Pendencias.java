package com.tcc.atendimento.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.tcc.atendimento.model.Pendencia;

public class Pendencias implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	@Inject
	public Pendencias(EntityManager manager){
		this.manager = manager;
		}
		
	public Pendencia porId(Long id){
		return manager.find(Pendencia.class, id);
	}	
	
	public Pendencia guardar(Pendencia pendencia){
		return this.manager.merge(pendencia);
	}
	
	public void remover(Pendencia pendencia){
		this.manager.remove(pendencia);
	}
	
	public List<Pendencia> todos(){
		TypedQuery<Pendencia> query = manager.createQuery("from Pendencia", Pendencia.class);
		return query.getResultList();
	}
	public void adicionar(Pendencia pendencia){
		this.manager.persist(pendencia);
	}
}
