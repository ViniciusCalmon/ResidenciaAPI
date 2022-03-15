package org.serratec.backend.ecommerce.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.serratec.backend.ecommerce.enums.StatusNome;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	@ApiModelProperty(value = "Identificador único do pedido")
	private Long id;

	@NotNull
	@Column(name = "data_pedido", nullable = false)
	@ApiModelProperty(value = "Data da realização do pedido", required = true)
	private LocalDate dataPedido;

	@Column(name = "data_entrega", nullable = true)
	@ApiModelProperty(value = "Data da entrega do pedido")
	private LocalDate dataEntrega;

	@Column(name = "data_envio", nullable = true)
	@ApiModelProperty(value = "Data em que o pedido foi enviado para o cliente")
	private LocalDate dataEnvio;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status", nullable = true)
	@ApiModelProperty(value = "Status do pedido")
	private StatusNome statusNome;

	@ManyToMany
	@JoinTable(name = "item_pedido", joinColumns = @JoinColumn(name = "id_pedido"), inverseJoinColumns = @JoinColumn(name = "id_produto"))
	@ApiModelProperty(value = "Lista de produtos associada ao pedido")
	private List<Produto> produtos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public StatusNome getStatusNome() {
		return statusNome;
	}

	public void setStatusNome(StatusNome statusNome) {
		this.statusNome = statusNome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", dataPedido=" + dataPedido + ", dataEntrega=" + dataEntrega + ", dataEnvio="
				+ dataEnvio + ", statusNome=" + statusNome + ", produtos=" + produtos + "]";
	}

}
