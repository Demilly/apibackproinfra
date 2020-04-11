package br.com.apiProInfraBack.model;

import java.io.Serializable;
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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "usuario")
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1937195872778249441L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_usuario", nullable = false)
	private Long cod_usuario;

	@NotBlank
    @Size(max = 120)
	private String primeiroNome;

	@NotBlank
    @Size(max = 120)
	private String ultimoNome;
	
	@Column(name = "email", nullable = false, unique = true, length = 255)
    @NotBlank
    @Size(max = 255)
    private String email;

	
	@Column(name = "cpf", nullable = false, unique = true, length = 20)
    @NotBlank
    @Size(max = 255)
	private String cpf;

	
	@Column(name = "telefone", length = 20)
    @Size(max = 20)
	private String telefone;

	
	@Column(name="ultima_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultima_atualizacao;
	
	@Column(name="data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_criacao;

	
	@Column(name = "data_nascimento", length = 11)
    @Size(max = 11)
	private String data_nascimento;

}