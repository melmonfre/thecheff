package com.theCheff.The.Cheff.util.dto;

import java.io.Serializable;

public class EventoDto<T> implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public EventoDto() {
	}

	public EventoDto(EventoEnum tipo, T objeto) {
		this.tipo = tipo;
		this.objeto = objeto;
	}

	private EventoEnum	tipo;
	private T			objeto;

	public EventoEnum getTipo() {
		return tipo;
	}

	public void setTipo(EventoEnum tipo) {
		this.tipo = tipo;
	}

	public T getObjeto() {
		return objeto;
	}

	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}

}