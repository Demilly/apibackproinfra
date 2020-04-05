package br.com.apiProInfraBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apiProInfraBack.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
