package org.serratec.backend.ecommerce.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class EnderecoNumeroDTO {

	@NotNull
	@Min(value = 1)
	@ApiModelProperty(value = "Número da residência", required = true)
	private Integer numero;

	@Size(max = 20, message = "Tamanho máximo: 20 caracteres")
	@ApiModelProperty(value = "Complemento do endereço da residência")
	private String complemento;

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

	@Override
	public String toString() {
		return "EnderecoNumeroComplementoDTO [numero=" + numero + ", complemento=" + complemento + "]";
	}

}
