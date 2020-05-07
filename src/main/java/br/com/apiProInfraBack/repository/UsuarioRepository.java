package br.com.apiProInfraBack.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.apiProInfraBack.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	void save(Optional<Usuario> usuario);
	
	Usuario findByEmail(String email);
	

}
