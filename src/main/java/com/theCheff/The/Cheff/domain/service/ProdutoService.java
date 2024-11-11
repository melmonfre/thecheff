package com.theCheff.The.Cheff.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.theCheff.The.Cheff.domain.entidades.Produto;
import com.theCheff.The.Cheff.domain.produtoRepositoy.ProdutoRepository;
import com.theCheff.The.Cheff.domain.repository.UserRepository;
import com.theCheff.The.Cheff.domain.user.User;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	UserRepository userRepository;

	public List<Produto> listarProdutos() {

		return produtoRepository.findAll();

	}

	public Produto salvarProduto(final Produto produto) {

		Long loggedUser = getLoggedUser();
		System.out.println("saida aqui >>>>" + loggedUser);

		User user = userRepository.findById(loggedUser)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		produto.setUser(user);
		return produtoRepository.save(produto);
	}

	public Produto listarProdutoPorID(final Long id) {

		//Long userId = getLoggedUser();
		// return produtoRepository.findByIdAndUserId(id, userId);
		// .orElseThrow(() -> new RuntimeException("Produto não encontrado ou você não
		// tem permissão para visualizá-lo"));

		return produtoRepository.findById(id).get();
	}

	public Produto listarProdutoPorNome(final String nome) {
		return produtoRepository.findByNomeProduto(nome);
	}

	public void deletarProduto(final Long id) {
		produtoRepository.deleteById(id);
	}

	public Long getLoggedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.isAuthenticated()) {
			Object principal = authentication.getPrincipal();

			if (principal instanceof User) {
				User customUser = (User) principal;
				return customUser.getId();
			}
		}
		return null;
	}

}
