package com.theCheff.The.Cheff.util;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nullable;

public class EnvelopeService<T> extends Envelope<T> {
	private static final long serialVersionUID = 1L;
	private boolean ok = true;

	public EnvelopeService() {
	}

	public EnvelopeService(T objeto) {
		this.objeto = objeto;
	}

	public EnvelopeService(T objeto, String mensagem, Object... valores) {
		this.objeto = objeto;
		this.mensagem = String.format(mensagem, valores);
	}

	public EnvelopeService(T objeto, String mensagem, boolean ok) {
		this.objeto = objeto;
		this.mensagem = mensagem;
		this.ok = ok;
	}

	public EnvelopeService(T objeto, boolean ok, String mensagem) {
		this.objeto = objeto;
		this.mensagem = mensagem;
		this.ok = ok;
	}

	public EnvelopeService(T objeto, boolean ok, String mensagem, @Nullable Object... valores) {
		this.objeto = objeto;
		this.mensagem = String.format(mensagem, valores);
		this.ok = ok;
	}

	public boolean isOk() {
		return this.ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	@JsonIgnore
	public Optional<T> getObjetoOptional() {
		return Optional.ofNullable(this.getObjeto());
	}

	public static <T> EnvelopeService<T> of(T objeto) {
		return new EnvelopeService(objeto);
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EnvelopeService [ok=");
		builder.append(this.ok);
		builder.append(", objeto=");
		builder.append(this.objeto);
		builder.append(", mensagem=");
		builder.append(this.mensagem);
		builder.append(", grupoPermissoes=");
		;
		builder.append(", eventos=");
		builder.append(this.eventos);
		builder.append("]");
		return builder.toString();
	}
}