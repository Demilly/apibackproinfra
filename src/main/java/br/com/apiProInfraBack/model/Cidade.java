package br.com.apiProInfraBack.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cidade implements Serializable {

	private static final long serialVersionUID = -8070033831752076343L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_cidade;
	
	private String nome;
	
	private String cep;	
	
	private String latitude;
	
	private String longitude;
	
	
}
