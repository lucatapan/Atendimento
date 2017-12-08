package com.tcc.atendimento.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="escola")
public class Escola implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

	private int codigo;

	private String coordenadorPedagogico;

	private String diretorAcademico;

	private String diretorAdministrativo;

	private String diretorUnidade;

	private String endereco;

	private String nome;

	private String orientadorEducacional;

	private String telefone;

	private String cidade;

	private Pendencia pendencia;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length=3, nullable=false)
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	@Column(length=60, nullable = false)
	public String getCoordenadorPedagogico() {
		return coordenadorPedagogico;
	}


	public void setCoordenadorPedagogico(String coordenadorPedagogico) {
		this.coordenadorPedagogico = coordenadorPedagogico;
	}
	@Column(length = 60, nullable = false)
	public String getDiretorAcademico() {
		return diretorAcademico;
	}

	public void setDiretorAcademico(String diretorAcademico) {
		this.diretorAcademico = diretorAcademico;
	}

	@Column(length=60, nullable = false)
	public String getDiretorAdministrativo() {
		return diretorAdministrativo;
	}

	public void setDiretorAdministrativo(String diretorAdministrativo) {
		this.diretorAdministrativo = diretorAdministrativo;
	}
	@Column(length=60, nullable=false)
	public String getDiretorUnidade() {
		return diretorUnidade;
	}

	public void setDiretorUnidade(String diretorUnidade) {
		this.diretorUnidade = diretorUnidade;
	}
	@Column(length=60, nullable = false)
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	@Column(length=60, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(length=60, nullable = false)
	public String getOrientadorEducacional() {
		return orientadorEducacional;
	}

	public void setOrientadorEducacional(String orientadorEducacional) {
		this.orientadorEducacional = orientadorEducacional;
	}

	@Column(length=20, nullable = false)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Column(length=60, nullable = false)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@ManyToOne(optional=false)
	@JoinColumn(name="pendencias_id")
	public Pendencia getPendencia() {
		return pendencia;
	}

	public void setPendencia(Pendencia pendencia) {
		this.pendencia = pendencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Escola other = (Escola) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}







}
