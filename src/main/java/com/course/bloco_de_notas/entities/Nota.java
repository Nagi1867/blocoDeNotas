package com.course.bloco_de_notas.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_user")
public class Nota implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String NomeNota;
    private String Conteudo;
    private Integer status;

    public Nota() {}

    public Nota(Long id, String nomeNota, String conteudo, Integer status) {
        this.id = id;
        NomeNota = nomeNota;
        Conteudo = conteudo;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeNota() {
        return NomeNota;
    }

    public void setNomeNota(String nomeNota) {
        NomeNota = nomeNota;
    }

    public String getConteudo() {
        return Conteudo;
    }

    public void setConteudo(String conteudo) {
        Conteudo = conteudo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nota nota = (Nota) o;
        return Objects.equals(id, nota.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
