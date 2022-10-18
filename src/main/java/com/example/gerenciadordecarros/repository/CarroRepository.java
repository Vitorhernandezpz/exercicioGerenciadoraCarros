package com.example.gerenciadordecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerenciadordecarros.domain.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {
}
