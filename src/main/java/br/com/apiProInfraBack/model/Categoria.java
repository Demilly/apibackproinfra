package br.com.apiProInfraBack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Categoria implements Serializable{

	private static final long serialVersionUID = -9164619198189040958L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_categoria;
	
	@Column(name = "nome_categoria", length = 120)
	private String nome_categoria;
	
	@Column(name = "status", length = 20)
    @Size(max = 20)
	private String status;

	public Categoria() {
	}

	public Categoria(Long cod_categoria, String nome_categoria, String status) {
		super();
		this.cod_categoria = cod_categoria;
		this.nome_categoria = nome_categoria;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
