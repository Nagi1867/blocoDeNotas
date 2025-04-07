package com.course.bloco_de_notas.services;

import com.course.bloco_de_notas.entities.Nota;
import com.course.bloco_de_notas.repositories.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {
    @Autowired
    private NotaRepository repository;

    public List<Nota> findAll() {
        return repository.findAll();
    }

    public Nota findById(Long id) {
        Optional<Nota> obj = repository.findById(id);
        return obj.get();
    }

    public Nota insert(Nota obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
