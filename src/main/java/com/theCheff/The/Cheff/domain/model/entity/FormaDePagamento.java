package com.theCheff.The.Cheff.domain.model.entity;

import java.util.ArrayList;
import java.util.List;

import com.theCheff.The.Cheff.domain.enums.FormaDePagamentoEnum;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormaDePagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    @ElementCollection(targetClass = FormaDePagamentoEnum.class)
    @CollectionTable(name = "forma_de_pagamento_enum", joinColumns = @JoinColumn(name = "forma_de_pagamento_id"))
    @Enumerated(EnumType.STRING)
    private List<FormaDePagamentoEnum> formasDePagamento = new ArrayList<>();
}