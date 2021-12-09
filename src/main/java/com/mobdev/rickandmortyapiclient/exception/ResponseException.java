package com.mobdev.rickandmortyapiclient.exception;

public class ResponseException extends Exception {

	private static final long serialVersionUID = 1L;
	protected final StatusResponseEnum statusResponseEnum;
	protected final boolean handled;

	/**
	 * ResponseException Respuesta generica cuando se produce una excepcion
	 * 
	 * @param message
	 * @param StatusResponseEnum
	 * @return field
	 */
	public ResponseException(String message, StatusResponseEnum responseStatusEnum) {
		super(message);
		this.statusResponseEnum = responseStatusEnum;
		this.handled = false;
	}

	/**
	 * ResponseException Respuesta controlada generica cuando se produce una
	 * excepcion
	 * 
	 * @param message
	 * @param StatusResponseEnum
	 * @param handled
	 * @return field
	 */
	public ResponseException(String message, StatusResponseEnum responseStatusEnum, boolean handled) {
		super(message);
		this.statusResponseEnum = responseStatusEnum;
		this.handled = handled;
	}

	public ResponseException(StatusResponseEnum statusResponseEnum, boolean handled2) {

		this.statusResponseEnum = statusResponseEnum;
		this.handled = handled2;
	}

	public StatusResponseEnum getStatusResponseEnum() {
		return statusResponseEnum;
	}

	public boolean isHandled() {
		return handled;
	}

}