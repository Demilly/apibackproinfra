//package br.com.apiProInfraBack.controller;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.Valid;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.apiProInfraBack.security.AccountCredentials;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiOperation;
//
//@CrossOrigin("*")
//@RestController
//@RequestMapping("/api")
//@ApiModel(value = "Cadastrar usuário")
//public class LoginController {
//	
//	@ApiOperation(value = "Faça o login e seja feliz!")
//	@PostMapping("/login")
//	@ResponseBody
//	public ResponseEntity<AccountCredentials> Post(@Valid @RequestBody AccountCredentials dados)
//    {
//		try {		
//			dados.getUsername();			
//			dados.getPassword();
//			
//	        return new ResponseEntity<AccountCredentials>(dados, HttpStatus.OK);
//			
//		}catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
//		}
//    }
//	
//	@PostMapping("/refresh_token")
//	public ResponseEntity<Void>refreshToken(HttpServletResponse response){
//		
//	}
//
//}
