package com.tcc.atendimento.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tcc.atendimento.model.Escola;
import com.tcc.atendimento.model.Pendencia;
import com.tcc.atendimento.repository.Pendencias;
import com.tcc.atendimento.service.CadastroEscola;

@Named
@ViewScoped
public class CadastroEscolaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroEscola cadastro;
	@Inject
	private Pendencias pendencias;

	private Escola escola = new Escola();
	private List<Pendencia> todasPendencias;

	public void prepararCadastro(){
		this.todasPendencias = this.pendencias.todos();
		if(this.escola == null){
			this.escola = new Escola();
		}
	}

	public void salvar(ActionEvent ae){
		FacesContext context = FacesContext.getCurrentInstance();
		try{
			this.cadastro.salvar(this.escola);
			this.escola = new Escola();
			context.addMessage(null, new FacesMessage("Escola salva com sucesso!"));

		} catch (Exception e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);

		}
	}
	public Escola getEscola() {

		return escola;
	}
	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	public List<Pendencia> getTodasPendencias() {
		return this.todasPendencias;
	}
	public void setTodasPendencias(List<Pendencia> todasPendencias) {
		this.todasPendencias = todasPendencias;
	}

}
