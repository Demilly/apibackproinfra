package br.com.apiProInfraBack.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.apiProInfraBack.model.Categoria;
import br.com.apiProInfraBack.repository.CategoriaRepository;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@ApiModel(value = "Categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository cr;

	@ApiOperation(value = "Retorna uma lista de todas as categorias")
	@GetMapping("/categorias")
	public List<Categoria> getCategorias() {
		return (List<Categoria>) cr.findAll();
	}

	@ApiOperation(value = "Insere uma categoria")
	@PostMapping("/categoria")
	@ResponseBody
	public ResponseEntity<Categoria> InsereCategoria(@Valid @RequestBody Categoria categoria) {
		try {

			cr.save(categoria);
			return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}

	@ApiOperation(value = "Atualiza os dados da categoria pelo cod_Categoria")
	@PutMapping("/categoria/{id}")
	public ResponseEntity<Object> atualizaCategoria(@RequestBody Categoria categoria, @PathVariable long id) {

		Optional<Categoria> categoriaOpitional = cr.findById(id);

		if (!categoriaOpitional.isPresent())
			return new ResponseEntity<>(HttpStatus.CONFLICT);

		categoria.setCod_categoria(id);

		cr.save(categoria);

		return new ResponseEntity<>(categoria, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Deleta um usuário pelo cod_categoria")
	@DeleteMapping("/categoria/{id}")
	public ResponseEntity<Object> deletaCategoriaId(@PathVariable(value = "id") long id)
    {
        Optional<Categoria> categoria = cr.findById(id);
        if(categoria.isPresent()){
        	cr.delete(categoria.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
	

}
