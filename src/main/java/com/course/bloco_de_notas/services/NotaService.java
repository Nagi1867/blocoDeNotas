package com.course.bloco_de_notas.services;

import com.course.bloco_de_notas.entities.Nota;
import com.course.bloco_de_notas.repositories.NotaRepository;
import com.course.bloco_de_notas.services.exceptions.DatabaseException;
import com.course.bloco_de_notas.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Nota insert(Nota obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Nota update(Long id, Nota obj) {
        try {
            Nota entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Nota entity, Nota obj) {
        entity.setNomeNota(obj.getNomeNota());
        entity.setConteudo(obj.getConteudo());
        entity.setStatus(obj.getStatus());
    }
}
