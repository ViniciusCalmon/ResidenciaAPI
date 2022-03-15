package org.serratec.backend.ecommerce.configuration;

import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class ConfigSeguranca extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}medu").roles("ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api/v1/categorias", "/api/v1/clientes", "/api/v1/enderecos",
						"/api/v1/funcionarios", "/api/v1/pedidos", "/api/v1/produtos")
				.permitAll()
				.antMatchers(HttpMethod.PUT, "/api/v1/categorias/{id}", "/api/v1/clientes/{id}",
						"/api/v1/enderecos/{id}", "/api/v1/funcionarios/{id}", "/api/v1/pedidos/{id}",
						"/api/v1/produtos/{id}")
				.hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/api/v1/categorias/{id}", "/api/v1/clientes/{id}",
						"/api/v1/enderecos/{id}", "/api/v1/funcionarios/{id}", "/api/v1/pedidos/{id}",
						"/api/v1/produtos/{id}")
				.hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/v1/categorias/{id}", "/api/v1/clientes/{id}",
						"/api/v1/enderecos/{id}", "/api/v1/funcionarios/{id}", "/api/v1/pedidos/{id}",
						"/api/v1/produtos/{id}")
				.hasRole("ADMIN").antMatchers(HttpMethod.PATCH, "/api/v1/produtos/atualiza-estoque/{id}")
				.hasRole("ADMIN").anyRequest().authenticated().and().httpBasic().and().cors().and().csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/v2/api-docs", "/swagger-ui/index.html");
	}

}
