package com.course.bloco_de_notas.config;

import com.course.bloco_de_notas.entities.Nota;
import com.course.bloco_de_notas.repositories.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private NotaRepository notaRepository;

    @Override
    public void run(String... args) throws Exception {
        Nota nota1 = new Nota(null, "Um dia", "O dia", 1);

        notaRepository.save(nota1);
    }
}
