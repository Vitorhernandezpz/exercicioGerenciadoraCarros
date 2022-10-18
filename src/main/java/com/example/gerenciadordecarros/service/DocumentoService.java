package com.example.gerenciadordecarros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerenciadordecarros.domain.Documento;
import com.example.gerenciadordecarros.repository.DocumentoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class DocumentoService {

    @Autowired
    DocumentoRepository repository;

    public Documento findOne(int id) throws ObjectNotFoundException {
        Optional<Documento> documento = repository.findById(id);

        return documento.orElseThrow(() -> new ObjectNotFoundException("Chave " + id + " não encontrada"));
    }

    public List<Documento> findAll() {
        return repository.findAll();
    }

    public Documento save(Documento documento) {
        return repository.save(documento);
    }

    public List<Documento> saveAll(List<Documento> documentos) {
        return repository.saveAll(documentos);
    }

    public Documento update(Documento documento) throws ObjectNotFoundException {
        Documento documentoExistente = findOne(documento.getId());
        documentoExistente.setTipo(documento.getTipo());
        documentoExistente.setNumero(documento.getNumero());

        return save(documentoExistente);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
