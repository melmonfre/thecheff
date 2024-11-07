package com.theCheff.The.Cheff.domain.produtoRepositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theCheff.The.Cheff.domain.entidades.ProdutoPedido;
import com.theCheff.The.Cheff.domain.entidades.ProdutoPedidoId;

@Repository
public interface ProdutoPedidoRepositoy extends JpaRepository<ProdutoPedido, ProdutoPedidoId> {

}