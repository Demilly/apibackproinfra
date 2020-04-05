package br.com.apiProInfraBack.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1937195872778249441L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long cod_usuario;

	@NotEmpty
	private String primeiroNome;

	@NotEmpty
	private String ultimoNome;

	private String cpf;

	private String telefone;

	@NotNull
	private LocalDateTime dataCriacao;
	
	@NotNull
	private LocalDateTime dataAtualizacao;

	@NotNull
	private Date data_nascimento;

	public Usuario() {
	}

	public Usuario(Long cod_usuario, @NotEmpty String primeiroNome, @NotEmpty String ultimoNome, String cpf,
			String telefone, LocalDateTime dataCriacao, @NotEmpty Date data_nascimento) {
		super();
		this.cod_usuario = cod_usuario;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataCriacao = dataCriacao;
		this.data_nascimento = data_nascimento;
	}

	public Long getCod_usuario() {
		return cod_usuario;
	}

	public void setCod_usuario(Long cod_usuario) {
		this.cod_usuario = cod_usuario;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	

}