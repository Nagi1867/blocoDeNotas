package com.course.bloco_de_notas.resources;

import com.course.bloco_de_notas.entities.Nota;
import com.course.bloco_de_notas.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/notas")
public class NotaResource {
    @Autowired
    private NotaService service;

    @GetMapping
    public ResponseEntity<List<Nota>> findAll() {
        List<Nota> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Nota> findById(@PathVariable Long id) {
        Nota obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping
    public ResponseEntity<Nota> insert(@RequestBody Nota obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
