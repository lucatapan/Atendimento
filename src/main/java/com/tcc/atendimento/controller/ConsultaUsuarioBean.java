package com.tcc.atendimento.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tcc.atendimento.model.Usuario;
import com.tcc.atendimento.repository.Usuarios;
import com.tcc.atendimento.service.CadastroUsuario;
import com.tcc.atendimento.service.NegocioException;

@Named
@ViewScoped
public class ConsultaUsuarioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuariosRepository;
	@Inject
	private CadastroUsuario cadastro;

	private Usuario usuarioSelecionado;
	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.excluir(this.usuarioSelecionado);
			this.consultar();
			context.addMessage(null, new FacesMessage(
					"Usuario excluído com sucesso!"));
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}


	private List<Usuario> usuarios;

	public void consultar(){
		this.usuarios = usuariosRepository.todos();
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

}
