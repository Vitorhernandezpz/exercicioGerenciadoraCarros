package com.example.gerenciadordecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerenciadordecarros.domain.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {
}
