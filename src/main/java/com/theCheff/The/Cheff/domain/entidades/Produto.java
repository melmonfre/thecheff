package com.theCheff.The.Cheff.domain.entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.theCheff.The.Cheff.domain.user.User;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	@NotBlank
	private String nomeProduto;
	@NotNull
	@Positive
	private BigDecimal preco;

	@JsonIgnore
	@OneToMany(mappedBy = "id.produto")
	private List<ProdutoPedido> pedidos = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "user_produto", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] image;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
