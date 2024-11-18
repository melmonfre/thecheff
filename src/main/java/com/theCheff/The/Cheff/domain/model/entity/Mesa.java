package com.theCheff.The.Cheff.domain.model.entity;

import java.time.Duration;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mesas")
public class Mesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pkMesas;

	@ManyToOne
	@JoinColumn(name = "restaurante_pk_restaurante")
	private Restaurante restaurante;

	@Column(nullable = false)
	private Integer numero;

	@Column(nullable = false, length = 20)
	private String cor;

	@Column(nullable = false)
	private boolean status; // true para usada, false para livre

	@Column
	private LocalDateTime tempoAberto;

	@Column(nullable = false)
	private double subtotal = 0.0;

	@Column(nullable = false)
	private double total = 0.0;

	public void setStatus(boolean status) {
		this.status = status;
		if (status) {
			this.tempoAberto = LocalDateTime.now();
		} else {
			this.tempoAberto = null;
		}
	}

	public long calcularTempoAbertoEmMinutos() {
		if (tempoAberto == null) {
			return 0;
		}
		return Duration.between(tempoAberto, LocalDateTime.now()).toMinutes();
	}

	public void adicionarAoSubtotal(double valor) {
		this.subtotal += valor;
	}

	public void fecharConta(double desconto) {
		this.total = this.subtotal - desconto;
		this.status = false; // Marca a mesa como livre
		this.tempoAberto = null; // Reseta o tempo
		this.subtotal = 0.0; // Reseta o subtotal
	}

}