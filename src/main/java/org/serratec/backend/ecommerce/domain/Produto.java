package org.serratec.backend.ecommerce.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	@ApiModelProperty(value = "Identificador únido do produto.")
	private Long id;

	@NotBlank
	@Size(max = 30, message = "Tamanho máximo: 30 caracteres")
	@Column(length = 30)
	@ApiModelProperty(value = "Nome do produto", required = true)
	private String nome;

	@Size(max = 100, message = "Tamanho máximo: 100 caracteres")
	@Column(length = 100)
	@ApiModelProperty(value = "Descrição com detalhes do produto")
	private String descricao;

	@NotNull
	@Column(name = "qtd_estoque")
	@ApiModelProperty(value = "Quantidade disponível em estoque para venda", required = true)
	private Integer qtdEstoque;

	@NotNull
	@Column(name = "data_cadastro")
	@ApiModelProperty(value = "Data em que o produto foi cadastrado", required = true)
	private LocalDate dataDadastro;

	@NotNull
	@Column(name = "valor_unitario")
	@ApiModelProperty(value = "Valor unitário de venda do produto", required = true)
	private BigDecimal valorUnitario;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	@ApiModelProperty(value = "Categoria do produto")
	private Categoria categoria;

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
