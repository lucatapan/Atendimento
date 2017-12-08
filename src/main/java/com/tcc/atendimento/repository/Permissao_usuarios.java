package com.tcc.atendimento.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.tcc.atendimento.model.Permissao_usuario;

public class Permissao_usuarios implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	@Inject
	public Permissao_usuarios(EntityManager manager) {
		this.manager = manager;
	}
	
	public Permissao_usuario porId(Long id) {
		return manager.find(Permissao_usuario.class, id);
	}
	
	public Permissao_usuario guardar(Permissao_usuario permissao_usuario){
		return this.manager.merge(permissao_usuario);
	}
	
	public void remover(Permissao_usuario permissao_usuario){
		this.manager.remove(permissao_usuario);
	}
	
	public List<Permissao_usuario> todos(){
		TypedQuery<Permissao_usuario> query = manager.createQuery("from Permissao_usuario", Permissao_usuario.class);
		return query.getResultList();
	}
	public void adicionar(Permissao_usuario permissao_usuario){
		this.manager.persist(permissao_usuario);
	}
}