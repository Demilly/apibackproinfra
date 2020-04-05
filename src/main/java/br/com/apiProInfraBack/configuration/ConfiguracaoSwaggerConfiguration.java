 package br.com.apiProInfraBack.configuration;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
 @EnableSwagger2
 public class ConfiguracaoSwaggerConfiguration {

 	@Bean
 	public Docket ApiDesafioIndra() {
 		return new Docket(DocumentationType.SWAGGER_2).select()
 				.apis(RequestHandlerSelectors.basePackage("br.com.apiProInfraBack")).paths(PathSelectors.regex("/.*"))
 				.build().apiInfo(metaInfo());
 	}

 	private ApiInfo metaInfo() {

 		ApiInfo apiInfo = new ApiInfo("API PRO-INFRA", "API PRO-INFRA", "1.0", "Terms of Service",
 				new Contact("https://www.linkedin.com/in/demilly-ferreira/", "(83) 98707-7504", "demilly_@hotmail.com	"),
 				"Apache License Version 2.0", "https://www.apache.org/licesen.html", new ArrayList<>());

 		return apiInfo;
 	}
 	
 	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
         registry.addResourceHandler("swagger-ui.html")
                 .addResourceLocations("classpath:/META-INF/resources/");
         registry.addResourceHandler("/webjars/**")
                 .addResourceLocations("classpath:/META-INF/resources/webjars/");
         
     }

}
