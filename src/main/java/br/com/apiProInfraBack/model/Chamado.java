package br.com.apiProInfraBack.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chamado implements Serializable{

	private static final long serialVersionUID = 5715280673572506105L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_chamado;
	
	private String status;
	
	private LocalDateTime dataCriacao;
	
	private Usuario usuario;
	
	private Categoria categoria;
	
	private String descricaoChamado;
		
	
}
