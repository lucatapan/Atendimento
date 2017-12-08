package com.tcc.atendimento.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tcc.atendimento.model.Permissao_usuario;
import com.tcc.atendimento.service.CadastroPermissao_usuario;

@Named
@ViewScoped
public class CadastroPermissaoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroPermissao_usuario cadastro;

	private Permissao_usuario permissao_usuario = new Permissao_usuario();

	public void salvar(ActionEvent ae) {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			this.cadastro.salvar(this.permissao_usuario);
			this.permissao_usuario = new Permissao_usuario();
			context.addMessage(null, new FacesMessage("Permissão cadastrada com sucesso"));


		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}

	}

	public Permissao_usuario getPermissao_usuario() {
		if(permissao_usuario == null) {
			permissao_usuario = new Permissao_usuario();
		}
		return permissao_usuario;
	}

	public void setPermissao_usuario(Permissao_usuario permissao_usuario) {
		this.permissao_usuario = permissao_usuario;
	}


}
