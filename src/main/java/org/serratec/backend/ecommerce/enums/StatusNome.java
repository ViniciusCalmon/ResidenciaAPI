package org.serratec.backend.ecommerce.enums;

import org.serratec.backend.ecommerce.exception.EnumValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusNome {

	AGUARDANDO_PAGAMENTO(1, "AGUARDANDO_PAGAMENTO"), PROCESSANDO_PAGAMENTO(2, "PROCESSANDO_PAGAMENTO"),
	PAGO_APROVADO(3, "PAGO_APROVADO"), PEDIDO_EM_SEPARACAO(4, "PEDIDO_EM_SEPARACAO"),
	PEDIDO_SEPARADO(5, "PEDIDO_SEPARADO"), PEDIDO_DESPACHADO(6, "PEDIDO_DESPACHADO"),
	PEDIDO_ENTREGUE(7, "PEDIDO_ENTREGUE"), PEDIDO_CANCELADO(8, "PEDIDO_CANCELADO");

	private Integer code;
	private String status;

	private StatusNome(Integer code, String status) {
		this.code = code;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	@JsonCreator
	public static StatusNome verifica(Integer value) throws EnumValidationException {
		for (StatusNome c : values()) {
			if (value.equals(c.getCode()))
				return c;
		}
		throw new EnumValidationException("Status preenchido incorretamente: " + value);
	}

	@JsonCreator
	public static StatusNome verifica(String value) throws EnumValidationException {
		for (StatusNome c : values()) {
			if (value.equals(c.getStatus()))
				return c;
		}
		throw new EnumValidationException("Status preenchido incorretamente: " + value);
	}

}
