package com.tcc.atendimento.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tcc.atendimento.model.Usuario;
import com.tcc.atendimento.service.CadastroUsuario;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroUsuario cadastro;

	private Usuario usuario = new Usuario();

	public void salvar(ActionEvent ae){
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			this.cadastro.salvar(this.usuario);
			this.usuario = new Usuario();
			context.addMessage(null, new FacesMessage("Usuario cadastrado com sucesso!"));

		} catch(Exception e){
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context	.addMessage(null, mensagem);
		}

	}

	public Usuario getUsuario() {
		if(usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
