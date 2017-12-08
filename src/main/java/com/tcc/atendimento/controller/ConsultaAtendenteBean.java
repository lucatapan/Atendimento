package com.tcc.atendimento.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tcc.atendimento.model.Atendente;
import com.tcc.atendimento.repository.Atendentes;
import com.tcc.atendimento.service.CadastroAtendente;
import com.tcc.atendimento.service.NegocioException;

@Named
@ViewScoped
public class ConsultaAtendenteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private Atendentes atendentesRepository;
	@Inject
	private CadastroAtendente cadastro;

	private Atendente atendenteSelecionado;
	
	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.excluir(this.atendenteSelecionado);
			this.consultar();
			context.addMessage(null, new FacesMessage(
					"Lançamento excluído com sucesso!"));
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	private List<Atendente> atendentes;

	public void consultar(){
		this.atendentes = atendentesRepository.todos();
	}
	public List<Atendente> getAtendentes() {
		return atendentes;
	}
	public Atendente getAtendenteSelecionado() {
		return atendenteSelecionado;
	}
	public void setAtendenteSelecionado(Atendente atendenteSelecionado) {
		this.atendenteSelecionado = atendenteSelecionado;
	}

}
