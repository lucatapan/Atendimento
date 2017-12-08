package com.tcc.atendimento.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tcc.atendimento.model.Escola;
import com.tcc.atendimento.repository.Escolas;
import com.tcc.atendimento.service.CadastroEscola;
import com.tcc.atendimento.service.NegocioException;

@Named
@ViewScoped
public class ConsultaEscolasBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private Escolas escolasRepository;
	@Inject
	private CadastroEscola cadastro;

	private Escola escolaSelecionado;
	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.excluir(this.escolaSelecionado);
			this.consultar();
			context.addMessage(null, new FacesMessage(
					"Lançamento excluído com sucesso!"));
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	private List<Escola> escolas;

	public void consultar(){
		this.escolas = escolasRepository.todos();
	}

	public List<Escola> getEscolas(){
		return escolas;
	}

	public Escola getEscolaSelecionado() {
		return escolaSelecionado;
	}

	public void setEscolaSelecionado(Escola escolaSelecionado) {
		this.escolaSelecionado = escolaSelecionado;
	}

}
