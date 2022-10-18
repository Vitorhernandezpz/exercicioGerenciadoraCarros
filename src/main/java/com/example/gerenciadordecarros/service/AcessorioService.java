package com.example.gerenciadordecarros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerenciadordecarros.domain.Acessorio;
import com.example.gerenciadordecarros.repository.AcessorioRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AcessorioService {

    @Autowired
    AcessorioRepository repository;

    public Acessorio findOne(int id) throws ObjectNotFoundException {
        Optional<Acessorio> acessorio = repository.findById(id);

        return acessorio.orElseThrow(() -> new ObjectNotFoundException("Acessório " + id + " não encontrado"));
    }

    public List<Acessorio> findAll() {
        return repository.findAll();
    }

    public Acessorio save(Acessorio acessorio) {
        return repository.save(acessorio);
    }

    public List<Acessorio> saveAll(List<Acessorio> acessorio) {
        return repository.saveAll(acessorio);
    }

    public Acessorio update(Acessorio acessorio) throws ObjectNotFoundException {
        Acessorio acessorioExistente = findOne(acessorio.getId());
        acessorioExistente.setNome(acessorio.getNome());

        return save(acessorioExistente);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
