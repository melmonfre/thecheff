package com.theCheff.The.Cheff;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.theCheff.The.Cheff.domain.produtoRepositoy.ProdutoRepository;

@SpringBootApplication
public class TheCheffApplication {

	@Autowired
	ProdutoRepository produtoRepository;
	
	public static void main(String[] args)  {
		SpringApplication.run(TheCheffApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		Produto produto = new Produto();
//		Produto bauru = new Produto();
//		bauru.setNomeProduto("Bauru");
//		bauru.setPreco(BigDecimal.valueOf(2.50));
//		produtoRepository.save(bauru);
//		produto.setNomeProduto("Misto Quente");
//		produto.setPreco(BigDecimal.valueOf(2.00));
//		produtoRepository.save(produto);
//	}

}
