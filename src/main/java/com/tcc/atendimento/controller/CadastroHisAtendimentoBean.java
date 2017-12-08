package com.tcc.atendimento.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tcc.atendimento.model.Atendente;
import com.tcc.atendimento.model.Escola;
import com.tcc.atendimento.model.HisAtendimento;
import com.tcc.atendimento.repository.Atendentes;
import com.tcc.atendimento.repository.Escolas;
import com.tcc.atendimento.service.CadastroHisAtendimento;
import com.tcc.atendimento.service.NegocioException;

@Named
@ViewScoped
public class CadastroHisAtendimentoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroHisAtendimento cadastro;
	@Inject
	private Atendentes atendentes;
	@Inject
	private Escolas escolas;
	
	private HisAtendimento hisAtendimento = new HisAtendimento();
	private List<Atendente> todosAtendentes;
	private List<Escola> todasEscolas;

	public void prepararCadastro(){
		this.todasEscolas = this.escolas.todos();
		this.todosAtendentes = this.atendentes.todos();
		if(this.hisAtendimento == null){
			this.hisAtendimento = new HisAtendimento();
		}
	}

	public void salvar(ActionEvent ae){
		FacesContext context = FacesContext.getCurrentInstance();
		try{
			this.cadastro.salvar(hisAtendimento);
			this.hisAtendimento = new HisAtendimento();
			context.addMessage(null, new FacesMessage("Historico de Atendimento salvo com sucesso!"));
		
		}catch(NegocioException e){
			
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context	.addMessage(null, mensagem);
		}
	}

	public HisAtendimento getHisAtendimento() {
		return hisAtendimento;
	}

	public void setHisAtendimento(HisAtendimento hisAtendimento) {
		this.hisAtendimento = hisAtendimento;
	}

	public List<Atendente> getTodosAtendentes() {
		return this.todosAtendentes;
	}

	public List<Escola> getTodasEscolas() {
		return this.todasEscolas;
	}

	public void setTodosAtendentes(List<Atendente> todosAtendentes) {
		this.todosAtendentes = todosAtendentes;
	}

	public void setTodasEscolas(List<Escola> todasEscolas) {
		this.todasEscolas = todasEscolas;
	}

	
}


