package org.serratec.backend.ecommerce.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	@ApiModelProperty(value = "Identificador único do cliente")
	private Long id;

	@Email(message = "Email inválido")
	@NotBlank
	@Size(max = 30, message = "Tamanho máximo: 30 caracteres")
	@Column(length = 30, nullable = false)
	@ApiModelProperty(value = "Email do cliente", required = true)
	private String email;

	@NotBlank
	@Size(max = 20, message = "Tamanho máximo: 20 caracteres")
	@Column(name = "nome_usuario", length = 20, nullable = false)
	@ApiModelProperty(value = "Nome de usuário para login", required = true)
	private String nomeUsuario;

	@NotBlank
	@Size(max = 60, message = "Tamanho máximo: 60 caracteres")
	@Column(name = "nome_completo", length = 60, nullable = false)
	@ApiModelProperty(value = "Nome completo do cliente", required = true)
	private String nomeCompleto;

	@Column(length = 255, nullable = true)
	@ApiModelProperty(value = "Senha para login")
	private String senha;

	@NotBlank
	@CPF(message = "CPF inválido")
	@Size(max = 14, message = "Tamanho máximo: 14 caracteres")
	@Column(length = 14, nullable = false)
	@ApiModelProperty(value = "Número do CPF do cliente", required = true)
	private String cpf;

	@NotBlank
	@Size(max = 13, message = "Tamanho máximo: 13 caracteres")
	@Column(length = 13, nullable = false)
	@ApiModelProperty(value = "Número de telefone do cliente", required = true)
	private String telefone;

	@NotNull
	@Column(name = "data_nasc", length = 10, nullable = false)
	@ApiModelProperty(value = "Data de nascimento do cliente", required = true)
	private LocalDate dataNasc;

	@OneToOne
	@JoinColumn(name = "id_endereco")
	@ApiModelProperty(value = "Endereço do cliente")
	private Endereco endereco;

	

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



	public Endereco getEndereco() {
		return endereco;
	}



	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}



	@Override
	public String toString() {
		return "\n E-mail: " + email + "\n Nome de usuário: " + nomeUsuario + "\n Nome Completo: " + nomeCompleto
				+ "\n Senha: " + senha + "\n CPF: " + cpf + "\n Data de Nascimento: " + dataNasc + "\n Telefone: "
				+ telefone + "\n Endereço: " + endereco + ".";
	}

}
