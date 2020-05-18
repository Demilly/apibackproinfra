package br.com.apiProInfraBack.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.apiProInfraBack.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

}
