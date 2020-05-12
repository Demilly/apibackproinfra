package br.com.apiProInfraBack.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Chamado implements Serializable{

	private static final long serialVersionUID = 5715280673572506105L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_chamado;
	
	private String status;
	
	private LocalDateTime dataCriacao;
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	private Usuario usuario;
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	private Categoria categoria;
	
	private String descricaoChamado;

	public Chamado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chamado(Long cod_chamado, String status, LocalDateTime dataCriacao, Usuario usuario, Categoria categoria,
			String descricaoChamado) {
		super();
		this.cod_chamado = cod_chamado;
		this.status = status;
		this.dataCriacao = dataCriacao;
		this.usuario = usuario;
		this.categoria = categoria;
		this.descricaoChamado = descricaoChamado;
	}

	public Long getCod_chamado() {
		return cod_chamado;
	}

	public void setCod_chamado(Long cod_chamado) {
		this.cod_chamado = cod_chamado;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescricaoChamado() {
		return descricaoChamado;
	}

	public void setDescricaoChamado(String descricaoChamado) {
		this.descricaoChamado = descricaoChamado;
	}
	

}
