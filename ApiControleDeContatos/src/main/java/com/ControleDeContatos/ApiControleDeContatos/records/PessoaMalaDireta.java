package com.ControleDeContatos.ApiControleDeContatos.records;

import com.ControleDeContatos.ApiControleDeContatos.model.Pessoa;

public record PessoaMalaDireta(Long id, String name, String malaDireta) {
    public static PessoaMalaDireta fromPessoa(Pessoa pessoa){
        String malaDireta = pessoa.getEndereco() + " - CEP: " + pessoa.getCep() + " - " + pessoa.getCidade()
                + "/" + pessoa.getUf();
        return new PessoaMalaDireta(pessoa.getId(), pessoa.getNome(), malaDireta);
    }
}
