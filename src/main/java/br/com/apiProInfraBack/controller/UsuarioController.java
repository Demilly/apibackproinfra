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
import org.springframework.web.bind.annotation.RestController;

import br.com.apiProInfraBack.model.Usuario;
import br.com.apiProInfraBack.repository.UsuarioRepository;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@ApiOperation(value = "Retorna uma lista de todos os usuários")
	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}
	
	
	@ApiOperation(value = "Retorna usuário pelo cod_usuario")
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> GetById(@PathVariable(value = "id") long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent())
			return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value = "Insere um usuário")
	@PostMapping("/usuario")
	public ResponseEntity<Usuario> Post(@Valid @RequestBody Usuario usuario)
    {
        usuarioRepository.save(usuario);        
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }


	@ApiOperation(value = "Atualiza um usuário pelo cod_usuario")
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Usuario newUsuario)
    {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
        	Usuario usuarioSalva = usuario.get();
        	usuarioSalva.setPrimeiroNome(newUsuario.getPrimeiroNome());
        	usuarioSalva.setCpf(newUsuario.getCpf());
        	usuarioSalva.setData_nascimento(newUsuario.getData_nascimento());
        	usuarioSalva.setUltimoNome(newUsuario.getUltimoNome());
        	usuarioSalva.setTelefone(newUsuario.getTelefone());
            usuarioRepository.save(usuario);
            return new ResponseEntity<Usuario>(usuarioSalva, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
	
	@ApiOperation(value = "Deleta um usuário pelo cod_usuario")
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            usuarioRepository.delete(usuario.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
