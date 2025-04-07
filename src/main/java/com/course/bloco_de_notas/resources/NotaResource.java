package com.course.bloco_de_notas.resources;

import com.course.bloco_de_notas.entities.Nota;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notas")
public class NotaResource {
    @GetMapping
    public ResponseEntity<Nota> findAll() {
        Nota nota1 = new Nota(1L, "Teste", "Testando", 1);
        return ResponseEntity.ok().body(nota1);
    }
}
