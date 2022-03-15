package org.serratec.backend.ecommerce.exception;

public class EnumValidationException extends Exception {

	private static final long serialVersionUID = 1L;

	public EnumValidationException() {
		super();
	}

	public EnumValidationException(String msg) {
		super(msg);
	}

	public EnumValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EnumValidationException(Throwable cause) {
		super(cause);
	}
}
