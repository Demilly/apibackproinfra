package br.com.apiProInfraBack.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = -9164619198189040958L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_categoria;

	@Column(name = "nome_categoria", length = 100)
	private String nome_categoria;

	@Column(name = "nome_imagem_categoria")
	private String nome_imagem_categoria;

	@Column(name = "status", length = 50)
	@Size(max = 20)
	private String status;

	@JsonIgnore
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	private List<Chamado> chamado = new ArrayList();

	public Categoria() {
	}

	public Categoria(Long cod_categoria, String nome_categoria, String nome_imagem_categoria,
			@Size(max = 20) String status, List<Chamado> chamado) {
		super();
		this.cod_categoria = cod_categoria;
		this.nome_categoria = nome_categoria;
		this.nome_imagem_categoria = nome_imagem_categoria;
		this.status = status;
		this.chamado = chamado;
	}

	public Long getCod_categoria() {
		return cod_categoria;
	}

	public void setCod_categoria(Long cod_categoria) {
		this.cod_categoria = cod_categoria;
	}

	public String getNome_categoria() {
		return nome_categoria;
	}

	public void setNome_categoria(String nome_categoria) {
		this.nome_categoria = nome_categoria;
	}

	public String getNome_imagem_categoria() {
		return nome_imagem_categoria;
	}

	public void setNome_imagem_categoria(String nome_imagem_categoria) {
		this.nome_imagem_categoria = nome_imagem_categoria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Chamado> getChamado() {
		return chamado;
	}

	public void setChamado(List<Chamado> chamado) {
		this.chamado = chamado;
	}
	
	
}