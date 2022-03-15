package org.serratec.backend.ecommerce.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class ProdutoComIdCategoriaDTO {

	@ApiModelProperty(value = "Identificador único do produto")
	private Long id;

	@NotBlank
	@Size(max = 30, message = "Tamanho máximo: 30 caracteres")
	@ApiModelProperty(value = "Nome do produto", required = true)
	private String nome;

	@Size(max = 100, message = "Tamanho máximo: 100 caracteres")
	@ApiModelProperty(value = "Descrição com detalhes do produto")
	private String descricao;

	@NotNull
	@ApiModelProperty(value = "Quantidade disponível em estoque para venda", required = true)
	private Integer qtdEstoque;

	@NotNull
	@ApiModelProperty(value = "Data em que o produto foi cadastrado", required = true)
	private LocalDate dataDadastro;

	@NotNull
	@ApiModelProperty(value = "Valor unitário de venda do produto", required = true)
	private BigDecimal valorUnitario;

	@ApiModelProperty(value = "Id da categoria do produto")
	private Long idCategoria;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public LocalDate getDataDadastro() {
		return dataDadastro;
	}

	public void setDataDadastro(LocalDate dataDadastro) {
		this.dataDadastro = dataDadastro;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

}
