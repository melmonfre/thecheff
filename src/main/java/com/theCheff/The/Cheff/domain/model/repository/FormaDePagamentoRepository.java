package com.theCheff.The.Cheff.domain.model.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theCheff.The.Cheff.domain.model.entity.FormaDePagamento;

public interface FormaDePagamentoRepository extends JpaRepository<FormaDePagamento, Integer> {
    FormaDePagamento findByRestauranteId(UUID id);
}