package org.serratec.backend.ecommerce.util;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EnderecoViaCep {

	@NotBlank
	@Size(max = 9, message = "Tamanho máximo: 9 caracteres")
	private String cep;

	@NotBlank
	@Size(max = 100, message = "Tamanho máximo: 100 caracteres")
	private String logradouro;

	@NotBlank
	@Size(max = 50, message = "Tamanho máximo: 50 caracteres")
	private String bairro;

	@Size(max = 30, message = "Tamanho máximo: 30 caracteres")
	@Column(length = 30)
	private String localidade;

	@Size(max = 20, message = "Tamanho máximo: 20 caracteres")
	private String complemento;

	@Size(min = 2, max = 2, message = "Tamanho: 2 caracteres")
	private String uf;

	private Integer numero;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "EnderecoViaCepDTO [cep=" + cep + ", logradouro=" + logradouro + ", bairro=" + bairro + ", localidade="
				+ localidade + ", complemento=" + complemento + ", uf=" + uf + ", numero=" + numero + "]";
	}

}
