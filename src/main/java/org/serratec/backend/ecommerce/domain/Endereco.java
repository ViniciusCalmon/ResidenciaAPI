package org.serratec.backend.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	@ApiModelProperty(value = "Identificador único do endereço")
	private Long id;

	@NotBlank
	@Size(max = 9, message = "Tamanho máximo: 9 caracteres")
	@Column(length = 9)
	@ApiModelProperty(value = "Número do CEP do endereço", required = true)
	private String cep;

	@NotBlank
	@Size(max = 100, message = "Tamanho máximo: 100 caracteres")
	@Column(length = 100)
	@ApiModelProperty(value = "Nome da rua/logradouro", required = true)
	private String rua;

	@NotBlank
	@Size(max = 50, message = "Tamanho máximo: 50 caracteres")
	@Column(length = 50)
	@ApiModelProperty(value = "Nome do bairro/distrito", required = true)
	private String bairro;

	@Size(max = 30, message = "Tamanho máximo: 30 caracteres")
	@Column(length = 30)
	@ApiModelProperty(value = "Nome da cidade")
	private String cidade;

	@NotNull
	@Min(value = 1)
	@Column(nullable = false)
	@ApiModelProperty(value = "Número da residência", required = true)
	private Integer numero;

	@Size(max = 20, message = "Tamanho máximo: 20 caracteres")
	@Column(length = 20)
	@ApiModelProperty(value = "Complemento do endereço da residência")
	private String complemento;

	@Size(min = 2, max = 2, message = "Tamanho: 2 caracteres")
	@Column(length = 2)
	@ApiModelProperty(value = "Nome do Estado (Unidade Federativa)")
	private String estado;

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCep() {
		return cep;
	}



	public void setCep(String cep) {
		this.cep = cep;
	}



	public String getRua() {
		return rua;
	}



	public void setRua(String rua) {
		this.rua = rua;
	}



	public String getBairro() {
		return bairro;
	}



	public void setBairro(String bairro) {
		this.bairro = bairro;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
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



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	@Override
	public String toString() {
		return rua + ", " + "Nº " + numero + " (complemento: " + complemento + "), " + bairro + " - " + cidade + "/"
				+ estado;
	}

}
