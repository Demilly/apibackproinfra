package br.com.apiProInfraBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apiProInfraBack.model.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Long>{

}	
