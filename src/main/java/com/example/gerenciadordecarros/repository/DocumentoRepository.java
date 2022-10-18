package com.example.gerenciadordecarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gerenciadordecarros.domain.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer> {
}
