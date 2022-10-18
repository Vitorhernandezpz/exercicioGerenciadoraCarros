package com.example.gerenciadordecarros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerenciadordecarros.domain.Chave;
import com.example.gerenciadordecarros.repository.ChaveRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ChaveService {

    @Autowired
    ChaveRepository repository;

    public Chave findOne(int id) throws ObjectNotFoundException {
        Optional<Chave> chave = repository.findById(id);

        return chave.orElseThrow(() -> new ObjectNotFoundException("Chave " + id + " não encontrada"));
    }

    public List<Chave> findAll() {
        return repository.findAll();
    }

    public Chave save(Chave chave) {
        return repository.save(chave);
    }

    public List<Chave> saveAll(List<Chave> chaves) {
        return repository.saveAll(chaves);
    }

    public Chave update(Chave chave) throws ObjectNotFoundException {
        Chave chaveExistente = findOne(chave.getId());
        chaveExistente.setCodigo(chave.getCodigo());

        return save(chaveExistente);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
