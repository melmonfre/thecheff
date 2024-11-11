package com.theCheff.The.Cheff.domain.entidades;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.theCheff.The.Cheff.domain.user.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
public class ProdutoPedidoId implements Serializable {

	@ManyToOne
	@JoinColumn(name = "idProduto")
	private Produto produto;
	
    @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idPedido")
	private Pedido pedido;

	// @JsonIgnore
	// @ManyToOne
	// @JoinColumn (name = "idUser")
	// private User user;

	
}