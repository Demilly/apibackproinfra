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

import br.com.apiProInfraBack.model.Chamado;
import br.com.apiProInfraBack.repository.ChamadoRepository;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@ApiModel(value = "Chamados")
public class ChamadoController {
	
	@Autowired
	private ChamadoRepository cr;
	
	@ApiOperation(value = "Retorna uma lista de todos os chamados independente de usuário")
	@GetMapping("/chamados")
	public List<Chamado> getUsuarios() {
		return (List<Chamado>) cr.findAll();
	}
	
	@ApiOperation(value = "Retorna chamado pelo cod_chamado")
	@GetMapping("/chamado/{id}")
	public ResponseEntity<Chamado> GetById(@PathVariable(value = "id") long id) {
		Optional<Chamado> chamado = cr.findById(id);
		if (chamado.isPresent())
			return new ResponseEntity<Chamado>(chamado.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value = "Insere um chamado")
	@PostMapping("/chamado")
	@ResponseBody
	public ResponseEntity<Chamado> Post(@Valid @RequestBody Chamado chamado)
    {
		try {		
			
			cr.save(chamado);        
	        return new ResponseEntity<Chamado>(chamado, HttpStatus.OK);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
    }
	
	@ApiOperation(value="Atualiza os dados de um chamado pelo id")
	@PutMapping("/chamado/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Chamado chamado, @PathVariable long id) {

		Optional<Chamado> chamadoOpitional = cr.findById(id);

		if (!chamadoOpitional.isPresent())
			 return new ResponseEntity<>(HttpStatus.CONFLICT);
		
		chamado.setCod_chamado(id);
		
		cr.save(chamado);

        return new ResponseEntity<>(chamado, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Deleta um chamado pelo cod_chamado")
	@DeleteMapping("/chamado/{id}")
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Chamado> chamado = cr.findById(id);
        if(chamado.isPresent()){
            cr.delete(chamado.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
