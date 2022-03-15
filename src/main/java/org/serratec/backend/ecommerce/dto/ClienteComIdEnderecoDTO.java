package org.serratec.backend.ecommerce.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.annotations.ApiModelProperty;

public class ClienteComIdEnderecoDTO {

	@ApiModelProperty(value = "Identificador único do cliente")
	private Long id;

	@Email(message = "Email inválido")
	@NotBlank
	@Size(max = 30, message = "Tamanho máximo: 30 caracteres")
	@ApiModelProperty(value = "Email do cliente", required = true)
	private String email;

	@NotBlank
	@Size(max = 20, message = "Tamanho máximo: 20 caracteres")
	@ApiModelProperty(value = "Nome de usuário para login", required = true)
	private String nomeUsuario;

	@NotBlank
	@Size(max = 60, message = "Tamanho máximo: 60 caracteres")
	@ApiModelProperty(value = "Nome completo do cliente", required = true)
	private String nomeCompleto;

	@ApiModelProperty(value = "Senha para login")
	private String senha;

	@NotBlank
	@CPF(message = "CPF inválido")
	@Size(max = 14, message = "Tamanho máximo: 14 caracteres")
	@ApiModelProperty(value = "Número do CPF do cliente", required = true)
	private String cpf;

	@NotBlank
	@Size(max = 13, message = "Tamanho máximo: 13 caracteres")
	@ApiModelProperty(value = "Número de telefone do cliente", required = true)
	private String telefone;

	@NotNull
	@ApiModelProperty(value = "Data de nascimento do cliente", required = true)
	private LocalDate dataNasc;

	@ApiModelProperty(value = "Id do endereço do cliente")
	private Long idEndereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

}
