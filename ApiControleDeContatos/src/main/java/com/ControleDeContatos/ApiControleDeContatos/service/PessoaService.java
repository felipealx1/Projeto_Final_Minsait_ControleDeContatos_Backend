package com.ControleDeContatos.ApiControleDeContatos.service;

import com.ControleDeContatos.ApiControleDeContatos.exception.PessoaNotFoundException;
import com.ControleDeContatos.ApiControleDeContatos.model.Pessoa;
import com.ControleDeContatos.ApiControleDeContatos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> buscarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa adicionarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscarPessoaId(Long id){
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException("A Pessoa não foi encontrada pelo id: " + id));
        }

    public Pessoa autalizarPessoa(Long id, Pessoa pessoaAtualizada){
        Pessoa pessoaExistente = pessoaRepository.findById(id)
                .orElseThrow(() ->new PessoaNotFoundException("Não foi possível atualizar a Pessoa, pois não foi encontrada pelo id" + id));
        pessoaExistente.setNome(pessoaAtualizada.getNome());
        pessoaExistente.setEndereco(pessoaAtualizada.getEndereco());
        pessoaExistente.setCep(pessoaAtualizada.getCep());
        pessoaExistente.setCidade(pessoaAtualizada.getCidade());
        pessoaExistente.setUf(pessoaAtualizada.getUf());

        return pessoaRepository.save(pessoaExistente);
    }

    public void deletarPessoa(Long id){
        pessoaRepository.deleteById(id);
    }
}
