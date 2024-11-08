package com.theCheff.The.Cheff.domain.produtoRepositoy;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theCheff.The.Cheff.domain.entidades.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Produto findByNomeProduto(String nomeProduto);
}