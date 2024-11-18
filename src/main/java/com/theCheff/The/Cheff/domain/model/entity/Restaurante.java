package com.theCheff.The.Cheff.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRestaurante;
    private String razaoSocial;
    private String cnpj;
    private String telefone;
    private String endereco;
    private String email;
    private String pedidoNamesa;

    @OneToMany(mappedBy = "restaurante")
    private Set<Mesa> mesas;

}