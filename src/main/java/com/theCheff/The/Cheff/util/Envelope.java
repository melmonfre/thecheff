package com.theCheff.The.Cheff.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.theCheff.The.Cheff.util.dto.EventoDto;

public abstract class Envelope<T> implements EnvelopeInterface, Serializable {
	/**
	 *
	 */
	private static final long		serialVersionUID	= 1L;

	protected T						objeto;
	protected String				mensagem			= "";
	@JsonIgnore

	protected List<EventoDto<?>>	eventos				= null;

	@JsonIgnore
	public abstract Optional<T> getObjetoOptional();

	public Envelope() {
		super();
	}

	@Override
	public final T getObjeto() {
		return objeto;
	}

	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}

	@Override
	public final String getMensagem() {
		return mensagem;
	}

	public Envelope<T> setMensagem (String mensagem) {
		if (null != mensagem) {
			this.mensagem = mensagem;
		}
		return this;
	}

	public List<EventoDto<?>> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoDto<?>> eventos) {
		this.eventos = eventos;
	}

	public void addEvento(EventoDto<?> evento) {
		if (this.eventos == null) {
			this.eventos = new ArrayList<>();
		}
		this.eventos.add(evento);
	}
}