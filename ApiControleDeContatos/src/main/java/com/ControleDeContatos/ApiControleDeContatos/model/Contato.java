package com.ControleDeContatos.ApiControleDeContatos.model;

import jakarta.persistence.*;

import java.util.Objects;

public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private TipoContato tipoContato;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @Column(nullable = false)
    private String contato;

    public Contato() {}

    public Contato(Long id, TipoContato tipoContato, Pessoa pessoa, String contato) {
        this.id = id;
        this.tipoContato = tipoContato;
        this.pessoa = pessoa;
        this.contato = contato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contato contato = (Contato) obj;
        return Objects.equals(id, contato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
