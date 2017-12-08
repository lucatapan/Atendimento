package com.tcc.atendimento.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.tcc.atendimento.model.Permissao_usuario;
import com.tcc.atendimento.repository.Permissao_usuarios;
import com.tcc.atendimento.util.Transactional;

public class CadastroPermissao_usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Permissao_usuarios permissao_usuarios;


	@Transactional
	public void salvar(Permissao_usuario permissao_usuario){
		this.permissao_usuarios.guardar(permissao_usuario);
	}
	@Transactional
	public void excluir(Permissao_usuario permissao_usuario) throws NegocioException{
		permissao_usuario = this.permissao_usuarios.porId(permissao_usuario.getId());
		this.permissao_usuarios.remover(permissao_usuario);
	}
}