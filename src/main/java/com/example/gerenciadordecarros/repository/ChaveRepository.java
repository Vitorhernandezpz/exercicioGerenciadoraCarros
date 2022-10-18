package com.example.gerenciadordecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerenciadordecarros.domain.Chave;

@Repository
public interface ChaveRepository extends JpaRepository<Chave, Integer> {
}
