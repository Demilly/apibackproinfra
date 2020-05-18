package br.com.apiProInfraBack.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apiProInfraBack.model.Chamado;
import br.com.apiProInfraBack.model.Usuario;

public interface ChamadoRepository extends JpaRepository<Chamado, Long>{
	
	@Transactional
	Chamado findByUsuario(Usuario usuario);
	

}	
