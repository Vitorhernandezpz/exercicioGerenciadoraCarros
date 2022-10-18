package com.example.gerenciadordecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerenciadordecarros.domain.Acessorio;

@Repository
public interface AcessorioRepository extends JpaRepository<Acessorio, Integer> {
}
