package com.tcc.atendimento.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tcc.atendimento.model.Pendencia;
import com.tcc.atendimento.service.CadastroPendencia;

@Named
@ViewScoped
public class CadastroPendenciaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroPendencia cadastro;

	private Pendencia pendencia = new Pendencia();

	public void salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.salvar(this.pendencia);
			System.out.println("descricao " + pendencia.getDescricao());

			this.pendencia = new Pendencia();
			context.addMessage(null, new FacesMessage("Pendencia cadastrada com sucesso!"));


		} catch (Exception e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);

		}
	}

	public Pendencia getPendencia() {
		if(pendencia == null){
			pendencia = new Pendencia();
		}
		return pendencia;
	}

	public void setPendencia(Pendencia pendencia) {
		this.pendencia = pendencia;
	}

}
