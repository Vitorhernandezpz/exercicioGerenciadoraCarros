package com.example.gerenciadordecarros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerenciadordecarros.domain.Fabricante;
import com.example.gerenciadordecarros.repository.FabricanteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class FabricanteService {

    @Autowired
    FabricanteRepository repository;

    public Fabricante findOne(int id) throws ObjectNotFoundException {
        Optional<Fabricante> fabricante = repository.findById(id);

        return fabricante.orElseThrow(() -> new ObjectNotFoundException("Fabricante " + id + " não encontrado"));
    }

    public List<Fabricante> findAll() {
        return repository.findAll();
    }

    public Fabricante save(Fabricante fabricante) {
        return repository.save(fabricante);
    }

    public List<Fabricante> saveAll(List<Fabricante> fabricante) {
        return repository.saveAll(fabricante);
    }

    public Fabricante update(Fabricante fabricante) throws ObjectNotFoundException {
        Fabricante fabricanteExistente = findOne(fabricante.getId());
        fabricanteExistente.setNome(fabricante.getNome());

        return save(fabricanteExistente);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
