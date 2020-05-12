package br.com.apiProInfraBack.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

//	@Value("${jwt.secret}")
	private String secret;

//	@Value("${JWT.expiration}")
	private Long expiration;

	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();

	}

	public Boolean tokenValido(String token) {
		Claims claims = getClains(token);
		if (claims != null) {
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			if (username != null && expirationDate != null & now.before(expirationDate)) {
				return true;
			}
		}
		return false;
	}

	private Claims getClains(String token) {

		try {

			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			return null;
		}

	}
	
	public String getUsername(String token) {
		Claims claims = getClains(token);
		if (claims != null) {
			return claims.getSubject();
		}
		return null;
	}

}
