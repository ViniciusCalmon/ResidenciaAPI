package org.serratec.backend.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	@ApiModelProperty(value = "Identificador únido da categoria")
	private Long id;

	@NotBlank
	@Size(max = 30, message = "Tamanho máximo: 30 caracteres")
	@Column(length = 30)
	@ApiModelProperty(value = "Nome da categoria", required = true)
	private String nome;

	@Size(max = 150, message = "Tamanho máximo: 150 caracteres")
	@Column(length = 150)
	@ApiModelProperty(value = "Descrição da categoria")
	private String descricao;

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



}
