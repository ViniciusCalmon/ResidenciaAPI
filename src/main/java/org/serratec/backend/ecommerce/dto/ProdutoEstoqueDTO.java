package org.serratec.backend.ecommerce.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class ProdutoEstoqueDTO {

	@NotNull
	@ApiModelProperty(value = "Quantidade a ser atualizada no estoque", required = true)
	private Integer qtdComprada;

	public Integer getQtdComprada() {
		return qtdComprada;
	}

	public void setQtdComprada(Integer qtdComprada) {
		this.qtdComprada = qtdComprada;
	}

}
