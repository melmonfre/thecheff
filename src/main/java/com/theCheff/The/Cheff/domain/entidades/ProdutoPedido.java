package com.theCheff.The.Cheff.domain.entidades;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "produto_pedido")
public class ProdutoPedido {
	@EmbeddedId
	private ProdutoPedidoId id = new ProdutoPedidoId();
	
	private int quantidade;
	

}