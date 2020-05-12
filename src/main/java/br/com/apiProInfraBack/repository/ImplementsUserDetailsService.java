//package br.com.apiProInfraBack.repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Repository;
//
//import br.com.apiProInfraBack.model.Usuario;
//
//@Repository
//public class ImplementsUserDetailsService implements UserDetailsService{
//
//	@Autowired
//	private UsuarioRepository ur;
//	
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		Usuario usuario = ur.findByEmail(email);
//		
//		if(usuario == null) {
//			throw new UsernameNotFoundException("Usuário não encontrado");
//		}
//		return usuario;
//	}
//
//}
