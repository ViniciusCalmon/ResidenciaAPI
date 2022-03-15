package org.serratec.backend.ecommerce.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	@ApiModelProperty(value = "Identificador únido do funcionário")
	private Long id;

	@NotBlank
	@Size(max = 50, message = "Tamanho máximo: 50 caracteres")
	@Column(length = 50)
	@ApiModelProperty(value = "Nome completo do funcionário", required = true)
	private String nome;

	@NotBlank
	@CPF(message = "CPF inválido")
	@Size(max = 14, message = "Tamanho máximo: 14 caracteres")
	@Column(length = 14)
	@ApiModelProperty(value = "Número do CPF do funcionário", required = true)
	private String cpf;

	@ManyToMany
	@JoinTable(name = "funcionario_produto", joinColumns = @JoinColumn(name = "id_funcionario"), inverseJoinColumns = @JoinColumn(name = "id_produto"))
	@ApiModelProperty(value = "Dados do funcionário responsável pelo cadastro de um produto")
	private List<Produto> produtos;

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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
