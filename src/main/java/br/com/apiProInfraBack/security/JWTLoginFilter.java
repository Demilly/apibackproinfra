//package br.com.apiProInfraBack.security;
//
//import java.io.IOException;
//import java.util.Collections;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import br.com.apiProInfraBack.repository.ImplementsUserDetailsService;
//import br.com.apiProInfraBack.repository.UsuarioRepository;
//
//public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
//
//	@Autowired
//	private UsuarioRepository ur;
//	
//	@Autowired
//	private ImplementsUserDetailsService userDetailsService;
//	
//	@Autowired
//	private TokenAuthenticationService jwt;
//
//
//	protected JWTLoginFilter(String url, AuthenticationManager authManager) {
//		super(new AntPathRequestMatcher(url));
//		setAuthenticationManager(authManager);
//	}
//
//	@Override
//	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//			throws AuthenticationException, IOException, ServletException {
//
//		AccountCredentials credentials = new ObjectMapper().readValue(request.getInputStream(),
//				AccountCredentials.class);
//		
//		response.setStatus(200);
//		response.setContentType("application/json");
//		response.getWriter()
//		.append("{\"msg\":\"login efetuado com sucesso\","
//				+ "\"token\":\""+ jwt.TOKEN_PREFIX + " "+ jwt.pegaToken() + "\","
//				+ "\"email\": \"" + credentials.getUsername().toString().trim() + "\"}");
//		
//		
//		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
//				credentials.getUsername(), credentials.getPassword(), Collections.emptyList())
//
//		);
//
//	}
//
//	@Override
//	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
//			FilterChain filterChain, Authentication auth) throws IOException, ServletException {
//
//		TokenAuthenticationService.addAuthentication(response, auth.getName());
//	}
//
//}