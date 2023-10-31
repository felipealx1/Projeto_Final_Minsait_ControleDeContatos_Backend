package com.ControleDeContatos.ApiControleDeContatos.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "TB_PESSOA")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = true)
    private String endereco;

    @Column(nullable = true)
    private String cep;

    @Column(nullable = true)
    private String cidade;

    @Column(nullable = true)
    private String uf;

    public Pessoa() {}

    public Pessoa(Long id, String nome, String endereco, String cep, String cidade, String uf) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pessoa pessoa = (Pessoa) obj;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
