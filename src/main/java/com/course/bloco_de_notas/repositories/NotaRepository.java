package com.course.bloco_de_notas.repositories;

import com.course.bloco_de_notas.entities.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}
