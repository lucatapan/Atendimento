package com.tcc.atendimento.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tcc.atendimento.model.Pendencia;
import com.tcc.atendimento.repository.Pendencias;
import com.tcc.atendimento.service.CadastroPendencia;
import com.tcc.atendimento.service.NegocioException;

@Named
@ViewScoped
public class ConsultaPendenciasBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private Pendencias pendenciasRepository;
	@Inject
	private CadastroPendencia cadastro;

	private Pendencia pendenciaSelecionado;
	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.excluir(this.pendenciaSelecionado);
			this.consultar();
			context.addMessage(null, new FacesMessage(
					"Lançamento excluído com sucesso!"));
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	private List<Pendencia> pendencias;

	public void consultar(){
		this.pendencias = pendenciasRepository.todos();
	}

	public List<Pendencia> getPendencias(){
		return pendencias;
	}

	public Pendencia getPendenciaSelecionado() {
		return pendenciaSelecionado;
	}

	public void setPendenciaSelecionado(Pendencia pendenciaSelecionado) {
		this.pendenciaSelecionado = pendenciaSelecionado;
	}

}
