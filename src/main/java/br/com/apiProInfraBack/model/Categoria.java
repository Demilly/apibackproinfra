package br.com.apiProInfraBack.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria implements Serializable{

	private static final long serialVersionUID = -9164619198189040958L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_categoria;
	
	private String nome_categoria;
	
	private String Ativo;
	
	
}
