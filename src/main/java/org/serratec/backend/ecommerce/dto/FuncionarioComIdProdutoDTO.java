package org.serratec.backend.ecommerce.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.annotations.ApiModelProperty;

public class FuncionarioComIdProdutoDTO {

	@ApiModelProperty(value = "Identificador únido do funcionário")
	private Long id;

	@NotBlank
	@Size(max = 50, message = "Tamanho máximo: 50 caracteres")
	@ApiModelProperty(value = "Nome completo do funcionário", required = true)
	private String nome;

	@NotBlank
	@CPF(message = "CPF inválido")
	@Size(max = 14, message = "Tamanho máximo: 14 caracteres")
	@ApiModelProperty(value = "Número do CPF do funcionário", required = true)
	private String cpf;

	@ApiModelProperty(value = "Ids dos produtos associados ao funcionário")
	private List<Long> idProdutos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Long> getIdProdutos() {
		return idProdutos;
	}

	public void setIdProdutos(List<Long> idProdutos) {
		this.idProdutos = idProdutos;
	}

}
