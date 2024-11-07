package com.theCheff.The.Cheff.domain.entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;




//@Data
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    //@NotBlank
   
    @NotNull
   // @Positive
    private BigDecimal preco;
    private String nomeProduto;
    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private List<ProdutoPedido> pedidos = new ArrayList<>();
    
    
    
	public Produto() {
		this.idProduto = idProduto;
		this.preco = preco;
		this.nomeProduto = nomeProduto;
		this.pedidos = pedidos;
	}
    
    
    
    
	public Produto(Long idProduto, BigDecimal preco, String nomeProduto, List<ProdutoPedido> pedidos) {
		super();
		this.idProduto = idProduto;
		this.preco = preco;
		this.nomeProduto = nomeProduto;
		this.pedidos = pedidos;
	}




	public Long getIdProduto() {
		return idProduto;
	}




	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}




	public BigDecimal getPreco() {
		return preco;
	}




	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}




	public String getNomeProduto() {
		return nomeProduto;
	}




	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}




	public List<ProdutoPedido> getPedidos() {
		return pedidos;
	}




	public void setPedidos(List<ProdutoPedido> pedidos) {
		this.pedidos = pedidos;
	}




	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", preco=" + preco + ", nomeProduto=" + nomeProduto + ", pedidos="
				+ pedidos + "]";
	}
    
    
    
    

}