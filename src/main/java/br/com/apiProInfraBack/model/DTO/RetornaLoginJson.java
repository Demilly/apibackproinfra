package br.com.apiProInfraBack.model.DTO;

import java.io.Serializable;

public class RetornaLoginJson implements Serializable{

	private static final long serialVersionUID = -3841557330768231225L;
	
	private Long cod_usuario;
	
	private String nomeCompleto;

	
	public RetornaLoginJson() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RetornaLoginJson(Long cod_usuario, String nomeCompleto) {
		super();
		this.cod_usuario = cod_usuario;
		this.nomeCompleto = nomeCompleto;
	}


	public Long getCod_usuario() {
		return cod_usuario;
	}


	public void setCod_usuario(Long cod_usuario) {
		this.cod_usuario = cod_usuario;
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}


	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
