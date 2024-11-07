package com.theCheff.The.Cheff.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theCheff.The.Cheff.domain.entidades.Produto;
import com.theCheff.The.Cheff.domain.produtoRepositoy.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	public Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto listarProdutoPorID(Long id) {
		return produtoRepository.findById(id).get();
	}

	public void deletarProduto(Long id) {
		produtoRepository.deleteById(id);
	}
}
