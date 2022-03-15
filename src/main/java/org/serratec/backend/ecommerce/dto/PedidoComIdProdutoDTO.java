package org.serratec.backend.ecommerce.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.serratec.backend.ecommerce.enums.StatusNome;

import io.swagger.annotations.ApiModelProperty;

public class PedidoComIdProdutoDTO {

	@ApiModelProperty(value = "Identificador único do pedido")
	private Long id;

	@ApiModelProperty(value = "Data da realização do pedido", required = true)
	private LocalDate dataPedido;

	@ApiModelProperty(value = "Data da entrega do pedido")
	private LocalDate dataEntrega;

	@ApiModelProperty(value = "Data em que o pedido foi enviado para o cliente")
	private LocalDate dataEnvio;

	@Enumerated(EnumType.ORDINAL)
	@ApiModelProperty(value = "Status do pedido")
	private StatusNome statusNome;

	@ApiModelProperty(value = "Ids dos produtos associados ao pedido")
	private List<Long> idProdutos;

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

	public List<Long> getIdProdutos() {
		return idProdutos;
	}

	public void setIdProdutos(List<Long> idProdutos) {
		this.idProdutos = idProdutos;
	}

}
