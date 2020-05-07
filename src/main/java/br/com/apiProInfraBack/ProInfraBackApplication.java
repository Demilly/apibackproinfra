package br.com.apiProInfraBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class ProInfraBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProInfraBackApplication.class, args);
		
		System.out.println(new BCryptPasswordEncoder().encode("123"));
		System.out.println(new BCryptPasswordEncoder().encode("cagar"));
	}

}
