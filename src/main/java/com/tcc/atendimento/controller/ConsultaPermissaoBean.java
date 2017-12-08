package com.tcc.atendimento.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tcc.atendimento.model.Permissao_usuario;
import com.tcc.atendimento.repository.Permissao_usuarios;
import com.tcc.atendimento.service.CadastroPermissao_usuario;
import com.tcc.atendimento.service.NegocioException;

@Named
@ViewScoped
public class ConsultaPermissaoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Permissao_usuarios permissaoRepository;
	@Inject
	private CadastroPermissao_usuario cadastro;

	private Permissao_usuario permissaoSelecionado;
	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.excluir(this.permissaoSelecionado);
			this.consultar();
			context.addMessage(null, new FacesMessage(
					"Lançamento excluído com sucesso!"));
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	private List<Permissao_usuario> permissao_usuarios;

	public void consultar(){
		this.permissao_usuarios = permissaoRepository.todos();
	}

	public Permissao_usuario getPermissaoSelecionado() {
		return permissaoSelecionado;
	}

	public void setPermissaoSelecionado(Permissao_usuario permissaoSelecionado) {
		this.permissaoSelecionado = permissaoSelecionado;
	}

	public List<Permissao_usuario> getPermissao_usuarios() {
		return permissao_usuarios;
	}

}
