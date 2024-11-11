package com.theCheff.The.Cheff.domain.produtoRepositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theCheff.The.Cheff.domain.entidades.Produto;
import com.theCheff.The.Cheff.domain.user.User;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	User user = new User();
	Produto findByNomeProduto(String nomeProduto);
}