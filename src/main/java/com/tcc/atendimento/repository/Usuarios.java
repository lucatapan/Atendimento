package com.tcc.atendimento.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.tcc.atendimento.model.Usuario;

public class Usuarios implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	@Inject
	public Usuarios(EntityManager manager) {
		this.manager = manager;
	}
	
	public Usuario porId(Long id) {
		return manager.find(Usuario.class, id);
	}
	
	public Usuario guardar(Usuario usuario){
		return this.manager.merge(usuario);
	}
	
	public void remover(Usuario usuario){
		this.manager.remove(usuario);
	}
	
	public List<Usuario> todos(){
		TypedQuery<Usuario> query = manager.createQuery("from Usuario", Usuario.class);
		return query.getResultList();
	}
	public void adicionar(Usuario usuario){
		this.manager.persist(usuario);
	}
}