package com.theCheff.The.Cheff.domain.model.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
}