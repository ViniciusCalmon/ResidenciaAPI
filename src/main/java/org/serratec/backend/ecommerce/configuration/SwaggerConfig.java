package org.serratec.backend.ecommerce.configuration;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("org.serratec.backend.ecommerce.controller"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {

		StringBuilder sb = new StringBuilder()
				.append("Projeto final da disciplina de Desenvolvimento de API Restful.\n\n")
				.append("Ministrada por: Marcelo Machado Collares.\n\n").append("Integrantes (grupo 1):\n")
				.append("- Carlos Eduardo de Carvalho\n").append("- Richard Lopes Neves Okubo\n")
				.append("- Victória Souza Cruz\n").append("- Cecília Justen\n").append("- Thalita Villa Nova")
				.append("- Vinicius Ferreira Calmon");

		ApiInfo apiInfo = new ApiInfoBuilder().title("API REST Ecommerce (grupo 1) [SERRATEC]")
				.description(sb.toString()).license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0").version("0.1.0")
				// .contact(new Contact("?")) email do grupo 1
				.build();

		return apiInfo;
	}
}
