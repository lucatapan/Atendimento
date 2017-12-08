package com.tcc.atendimento.controller;

import java.io.FileOutputStream;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.tcc.atendimento.model.Atendente;
import com.tcc.atendimento.service.CadastroAtendente;

@Named
@ViewScoped
public class CadastroAtendenteBean implements Serializable{

	private static final long serialVersionUID =1L;

	@Inject
	private CadastroAtendente cadastro;


	private Atendente atendente = new Atendente();

	public void salvar(ActionEvent ae){
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			this.cadastro.salvar(this.atendente);
			String arquivo = "C:\\Users\\Luciano\\Documents\\4bcc\\redes\\segundo semestre\\Squid.conf";
			String texto = atendente.getNome();
			FileOutputStream buffer = null;
			buffer = new FileOutputStream(arquivo); 
			buffer.write(texto.getBytes());  
			buffer.close();
			
			this.atendente = new Atendente();
			context.addMessage(null, new FacesMessage("Atendente cadastrado com sucesso!"));

		} catch(Exception e){
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context	.addMessage(null, mensagem);
		}

	}

	public Atendente getAtendente() {
		if(atendente == null){
			atendente = new Atendente();
		}
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}



}
