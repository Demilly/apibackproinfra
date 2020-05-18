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
	
	private String situacao;
	
	private LocalDateTime dataCriacao;
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	private Usuario usuario;
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	private Categoria categoria;
	
	private String descricaoChamado;
	
	private String latitude;
	
	private String longitude;

	public Chamado() {
	}

	public Chamado(Long cod_chamado, String situacao, LocalDateTime dataCriacao, Usuario usuario, Categoria categoria,
			String descricaoChamado, String latitude, String longitude) {
		super();
		this.cod_chamado = cod_chamado;
		this.situacao = situacao;
		this.dataCriacao = dataCriacao;
		this.usuario = usuario;
		this.categoria = categoria;
		this.descricaoChamado = descricaoChamado;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getCod_chamado() {
		return cod_chamado;
	}

	public void setCod_chamado(Long cod_chamado) {
		this.cod_chamado = cod_chamado;
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

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	

}
