package com.tcc.atendimento.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tcc.atendimento.model.HisAtendimento;
import com.tcc.atendimento.repository.HisAtendimentos;
import com.tcc.atendimento.service.CadastroHisAtendimento;
import com.tcc.atendimento.service.NegocioException;

@Named
@ViewScoped
public class ConsultaHisAtendimentoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private HisAtendimentos hisAtendimentosRepository;
	@Inject
	private CadastroHisAtendimento cadastro;

	private HisAtendimento hisAtendimentoSelecionado;
	
	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.excluir(this.hisAtendimentoSelecionado);
			this.consultar();
			context.addMessage(null, new FacesMessage(
					"Lançamento excluído com sucesso!"));
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	private List<HisAtendimento> hisAtendimentos;
	
	public void consultar(){
		this.hisAtendimentos = hisAtendimentosRepository.todos();

	}

	public List<HisAtendimento> getHisAtendimentos(){
		return hisAtendimentos;
	}

	public HisAtendimento getHisAtendimentoSelecionado() {
		return hisAtendimentoSelecionado;
	}

	public void setHisAtendimentoSelecionado(HisAtendimento hisAtendimentoSelecionado) {
		this.hisAtendimentoSelecionado = hisAtendimentoSelecionado;
	}
}
