package br.com.apiProInfraBack.repository;

import br.com.apiProInfraBack.model.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	void save(Optional<Usuario> usuario);

}
