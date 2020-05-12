package br.com.apiProInfraBack.model.DTO;

import java.io.Serializable;

public class LoginDTO implements Serializable{

	private static final long serialVersionUID = 2642601332169430064L;
	private String email;
	private String senha;

	public LoginDTO() {
	}

	public LoginDTO(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
