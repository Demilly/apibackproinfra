package br.com.apiProInfraBack.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails, Serializable{

	private static final long serialVersionUID = 1937195872778249441L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_usuario", nullable = false)
	private Long cod_usuario;

	@NotBlank
    @Size(max = 120)
	private String nomeCompleto;
	
	@Column(name = "email", nullable = false, unique = true, length = 120)
    @NotBlank
    @Size(max = 20)
    private String email;
	
	@Column(name = "senha", nullable = false, length = 120)
	@NotBlank
    @Size(max = 255)
	private String senha;

	
	@Column(name = "cpf", nullable = false, unique = true, length = 20)
    @NotBlank
    @Size(max = 20)
	private String cpf;

	
	@Column(name = "telefone", length = 15)
    @Size(max = 15)
	private String telefone;
	
	@Column(name = "data_nascimento", length = 11)
    @Size(max = 11)
	private String data_nascimento;

	
	@JsonIgnore
	@Column(name = "ultima_atualizacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;


	public Usuario() {
	}
	
	public Usuario(Long cod_usuario, @NotBlank @Size(max = 120) String nomeCompleto,
			@NotBlank @Size(max = 20) String email, @Size(max = 20) String senha, @NotBlank @Size(max = 20) String cpf,
			@Size(max = 15) String telefone, @Size(max = 11) String data_nascimento, Calendar creationDate,
			Calendar updateDate) {
		super();
		this.cod_usuario = cod_usuario;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.telefone = telefone;
		this.data_nascimento = data_nascimento;
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

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		this.updateDate = timestamp;
	}
	
	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}

	@JsonIgnore
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}