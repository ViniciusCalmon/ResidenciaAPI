package org.serratec.backend.ecommerce.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class EnderecoCepNumeroDTO {

	@NotBlank
	@Size(max = 9, message = "Tamanho máximo: 9 caracteres")
	@ApiModelProperty(value = "Número do CEP do endereço", required = true)
	private String cep;

	@NotNull
	@Min(value = 1)
	@ApiModelProperty(value = "Número da residência", required = true)
	private Integer numero;

	@Size(max = 20, message = "Tamanho máximo: 20 caracteres")
	@ApiModelProperty(value = "Complemento do endereço da residência")
	private String complemento;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
